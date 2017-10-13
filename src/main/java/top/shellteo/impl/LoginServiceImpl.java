package top.shellteo.impl;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shellteo.entity.Response;
import top.shellteo.mapper.UUserMapper;
import top.shellteo.pojo.UUser;
import top.shellteo.service.LoginService;
import top.shellteo.util.ConstantShow;
import top.shellteo.util.HttpUtils;
import top.shellteo.util.UUIDUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by HP on 2017/10/12.
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    private static Logger logger = Logger.getLogger(LoginServiceImpl.class);
    @Autowired
    private UUserMapper uUserMapper;
    @Override
    public String login(String js_code, HttpServletRequest request) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+ ConstantShow.appid+"&secret="+ConstantShow.secret+"&js_code="+js_code+"&grant_type="+ConstantShow.grant_type;
        logger.info("开始登录:"+url);
        String uuid = "";//返回的登录态
        try{
            //1.调用接口获取openid
            String resHttp = HttpUtils.get(url,"UTF-8");
            JSONObject jsonObject = JSONObject.fromObject(resHttp);
            //2.生成uuid,并组装数据存入session,作为登录态校验
            String openId = String.valueOf(jsonObject.get("openid"));
            String session_key = String.valueOf(jsonObject.get("session_key"));
            String unionid = String.valueOf(jsonObject.get("unionid"));
            if ("null".equals(openId) || "null".equals(session_key)){
                String errorCode = String.valueOf(jsonObject.get("errcode"));
                String errorMsg = String.valueOf(jsonObject.get("errmsg"));
                logger.error("==>登陆失败,错误码:"+errorCode+" 错误信息:"+errorMsg);
                return JSONObject.fromObject(new Response("0",errorCode,errorMsg,"")).toString();
            }

            uuid = UUIDUtil.getUUID();
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1200);//单位:秒 这里设置的是本次请求的超时时间
            session.setAttribute(uuid,session_key+"-"+openId);//登录凭证

            //3.openid存库,用户可能已经登陆过,先查询有无该用户
            //注意:前端发出登录请求时,session中可能还存有该用户登录数据,此时,不需要理会,再生成一个session即可,原先的session由于session设置的时效性会自动失效
            //:session设置时效性,失效后会自动销毁,每个用户都会生成一个session,session销毁后会查不到该用户的登录信息,此时,需要重新登录
            UUser uUser = uUserMapper.selectByPrimaryKey(openId);
            if (uUser == null){
                uUser = new UUser();
                uUser.setOpenid(openId);
                uUser.setUnionid(unionid);
                uUserMapper.insert(uUser);
            }
            String jsonData = "{\"loginId\":"+uuid+"}";
            return JSONObject.fromObject(new Response("1","","",jsonData)).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>登陆失败 错误信息:"+e);
            return JSONObject.fromObject(new Response("0","",e.getMessage(),"")).toString();
        }
    }
}
