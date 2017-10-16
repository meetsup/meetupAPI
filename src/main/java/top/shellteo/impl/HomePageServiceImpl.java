package top.shellteo.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shellteo.entity.ActivityPage;
import top.shellteo.entity.Response;
import top.shellteo.mapper.BActivityMapper;
import top.shellteo.mapper.UUserMapper;
import top.shellteo.service.HomePageService;

import java.util.List;

/**
 * Created by HP on 2017/10/16.
 */
@Service("HomePageService")
public class HomePageServiceImpl implements HomePageService {
    @Autowired
    private UUserMapper uUserMapper;
    @Autowired
    private BActivityMapper bActivityMapper;
    private Logger logger = Logger.getLogger(HomePageServiceImpl.class);
    @Override
    public String getAllActivityLimit(String jsonData) {
        logger.info("==>首页列表查询开始");
        try{
            if (StringUtils.isBlank(jsonData)){
                return JSONObject.fromObject(new Response("1","","入参为空,请检查","")).toString();
            }
            JSONObject object = JSONObject.fromObject(jsonData);
            String openId = object.get("openId").toString();
            String page = object.get("page").toString();//分页查询中的第几页
            String size = object.get("size").toString();//每页显示的条数

            //1.校验是否已经登录
            if (uUserMapper.selectByPrimaryKey(openId) == null){
                return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
            }

            //2.查询数据返回
            List<ActivityPage> activityPageList = null;
            if (StringUtils.isNotBlank(page) && StringUtils.isNotBlank(size)){
                int begin = (Integer.valueOf(page)-1) * Integer.valueOf(size);
                activityPageList = bActivityMapper.selectActivitiesByLimit(begin,Integer.valueOf(size));
            }
            String ret = JSONArray.fromObject(activityPageList).toString();
            logger.info("==>首页列表查询结束");
            return JSONObject.fromObject(new Response("0","","",ret)).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>首页列表查询失败:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }
}
