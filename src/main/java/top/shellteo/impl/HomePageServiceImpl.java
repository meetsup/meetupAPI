package top.shellteo.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.shellteo.entity.BActivityPage;
import top.shellteo.entity.Response;
import top.shellteo.mapper.BActivityMapper;
import top.shellteo.mapper.UUserMapper;
import top.shellteo.pojo.BActivity;
import top.shellteo.service.HomePageService;
import top.shellteo.util.BeanConvert;
import top.shellteo.util.JsonDateConvert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public String getAllActivityLimit(String jsonData, String type) {
        logger.info("==>首页列表查询/搜索开始");
        try{
            if (StringUtils.isBlank(jsonData)){
                return JSONObject.fromObject(new Response("1","","入参为空,请检查","")).toString();
            }
            JSONObject object = JSONObject.fromObject(jsonData);
            String openId = object.get("openId").toString();
            String page = object.get("page")==null ? "1":object.get("page").toString();//分页查询中的第几页
            String size = object.get("size")==null? "10":object.get("size").toString();//每页显示的条数
            String condiction = "";
            if ("search".equals(type) && object.get("value")!=null){
                //return JSONObject.fromObject(new Response("1","","搜索条件为空","")).toString();
                condiction = object.get("value").toString();//搜索条件
            }

            //1.校验是否已经登录
            if (uUserMapper.selectByPrimaryKey(openId) == null){
                return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
            }

            //2.查询数据返回
            List<BActivityPage> activityPageList = null;
            int begin = (Integer.valueOf(page)-1) * Integer.valueOf(size);
            if ("list".equals(type)){  //表示列表查询
                if (StringUtils.isNotBlank(page) && StringUtils.isNotBlank(size)){
                    activityPageList = bActivityMapper.selectActivitiesByLimit(begin,Integer.valueOf(size));
                }
            }
            if ("search".equals(type)){  //表示搜索
                activityPageList = bActivityMapper.selectActivitiesSearch(condiction,begin,Integer.valueOf(size));
            }
            JSONArray ret = JSONArray.fromObject(activityPageList);
            logger.info("==>首页列表查询/搜索结束");
            return JSONObject.fromObject(new Response("0","","",ret)).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>首页列表查询/搜索失败:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    @Transactional
    public String getDetail(String jsonData) {
        logger.info("==>获取活动详细信息开始");
        try{
            if (StringUtils.isBlank(jsonData)){
                return JSONObject.fromObject(new Response("1","","入参为空,请检查","")).toString();
            }
            JSONObject object = JSONObject.fromObject(jsonData);
            String openId = object.get("openId").toString();
            String activityId = object.get("activityId").toString();
            //1.校验是否已经登录
            if (uUserMapper.selectByPrimaryKey(openId) == null){
                return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
            }
            BActivity bActivity = new BActivity();
            //2.返回数据
            if (StringUtils.isNotBlank(activityId)){
                bActivity = bActivityMapper.selectByPrimaryKey(activityId);
            }

            BActivityPage bActivityPage = new BActivityPage();
            bActivityPage = (BActivityPage) BeanConvert.objConvertobj(bActivity,bActivityPage);
            //3.增加浏览数
            String browseCount = StringUtils.isBlank(bActivity.getBrowsecount()) ? "1" : String.valueOf(Integer.valueOf(bActivity.getBrowsecount())+1);
            bActivity.setBrowsecount(browseCount);
            bActivity.setUpdatetime(new Date());
            bActivityMapper.updateByPrimaryKeySelective(bActivity);
            return JSONObject.fromObject(new Response("0","","",bActivityPage)).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>获取活动详细信息失败:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

}
