package top.shellteo.impl;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.shellteo.entity.Response;
import top.shellteo.pojo.UUser;
import top.shellteo.service.LoginService;
import top.shellteo.util.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Created by HP on 2017/10/12.
 */
@Service("LoginService")
public class LoginServiceImpl extends BatisMapper implements LoginService {
    private static Logger logger = Logger.getLogger(LoginServiceImpl.class);
    @Override
    @Transactional
    public String login(String js_code, HttpServletRequest request) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+ ConstantShow.appid+"&secret="+ConstantShow.secret+"&js_code="+js_code+"&grant_type="+ConstantShow.grant_type;
        logger.info("==>开始登录:"+url);
        //String uuid = "";//返回的登录态
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
                return JSONObject.fromObject(new Response("1",errorCode,errorMsg,"")).toString();
            }

            /*uuid = UUIDUtil.getUUID();
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1200);//单位:秒 这里设置的是本次请求的超时时间
            session.setAttribute(uuid,session_key+"-"+openId);//登录凭证*/

            //3.openid存库,用户可能已经登陆过,先查询有无该用户
            //注意:前端发出登录请求时,session中可能还存有该用户登录数据,此时,不需要理会,再生成一个session即可,原先的session由于session设置的时效性会自动失效
            //:session设置时效性,失效后会自动销毁,每个用户都会生成一个session,session销毁后会查不到该用户的登录信息,此时,需要重新登录
            UUser uUser = uUserMapper.selectByPrimaryKey(openId);
            if (uUser == null){
                uUser = new UUser();
                uUser.setOpenid(openId);
                uUser.setUnionid(unionid);
                uUser.setCreatetime(new Date());
                uUser.setSessionKey(session_key);
                uUserMapper.insert(uUser);
            }else {
                uUser = new UUser();
                uUser.setSessionKey(session_key);
                uUser.setOpenid(openId);
                uUser.setCreatetime(new Date());
                uUserMapper.updateByPrimaryKeySelective(uUser);
            }
            //String jsonData = "{\"openId\":"+openId+"}";
            JSONObject object = new JSONObject();
            object.accumulate("openId",openId);
            //JSONObject object = JSONObject.fromObject(jsonData);
            logger.info("==>登录结束");
            return JSONObject.fromObject(new Response("0","","",object)).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>登陆失败 错误信息:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    @Transactional
    public String saveUser(String savaJson, HttpServletRequest request) {//String signature, String rawData, String encryptedData, String iv
        //不验证是否已经登陆,前端登录之后若成功直接调用
        logger.info("==>开始保存用户私密信息,入参:"+savaJson);
        //1.获取json数据
        JSONObject object = JSONObject.fromObject(savaJson);
        String signature = String.valueOf(object.get("signature"));
        String rawData = String.valueOf(object.get("rawData"));
        String encryptedData = String.valueOf(object.get("encryptedData"));
        String iv = String.valueOf(object.get("iv"));
        String openId = String.valueOf(object.get("openId"));
        String session_key = uUserMapper.selectByPrimaryKey(openId).getSessionKey();
        if (StringUtils.isBlank(signature) || StringUtils.isBlank(rawData) || StringUtils.isBlank(encryptedData) || StringUtils.isBlank(iv) || StringUtils.isBlank(openId)){
            logger.error("==>保存用户私密信息失败:入参数据有异常,请检查");
            return String.valueOf(JSONObject.fromObject(new Response("1","","入参数据有空值,请检查","")));
        }

        //2.校验用户数据完整性
        UUser uUser = null;
        try{
            /*String openidAndSessionkey = (String) request.getSession().getAttribute(uuid);
            String sessionKey = openidAndSessionkey.split("-")[0];*/
            String te = rawData+session_key;
            String signature2 = AESUtil.getSha1(rawData+session_key);
            if (signature != signature2){
                logger.error("==>保存用户私密信息失败:签名密钥验证失败");
                return JSONObject.fromObject(new Response("1","","签名密钥验证失败","")).toString();
            }

            //3.用户数据解密
            String encryptedDataDecode = "";
            byte[] bytes = AESUtil.instance.decrypt(Base64.decodeBase64(encryptedData),Base64.decodeBase64(session_key),Base64.decodeBase64(iv));
            if (bytes!=null && bytes.length>0){
                encryptedDataDecode = new String(bytes,"UTF-8");
            }

            //4.用户信息存库
            if (StringUtils.isNotBlank(encryptedDataDecode)){
                JSONObject encryptedObject = JSONObject.fromObject(encryptedDataDecode);
                encryptedObject.remove("watermark");//此数据不存储
                uUser = (UUser) JSONObject.toBean(encryptedObject,UUser.class);
                UUser uUser1 = uUserMapper.selectByPrimaryKey(uUser.getOpenid());
                if (uUser1 != null){
                    //更新
                    uUser.setUpdatetime(new Date());
                    uUserMapper.updateByPrimaryKeySelective(uUser);
                }else {
                    //插入
                    uUser.setCreatetime(new Date());
                    uUserMapper.insertSelective(uUser);
                }
            }
            logger.info("保存用户信息结束");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>保存用户私密信息失败:"+e);
        }
        return JSONObject.fromObject(new Response("0","","",JSONObject.fromObject(uUser))).toString();
    }
}
