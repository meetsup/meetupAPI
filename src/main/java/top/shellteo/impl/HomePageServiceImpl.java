package top.shellteo.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.shellteo.entity.BActivityPage;
import top.shellteo.entity.Response;
import top.shellteo.pojo.*;
import top.shellteo.service.HomePageService;
import top.shellteo.util.BatisMapper;
import top.shellteo.util.BeanConvert;
import top.shellteo.util.ConstantShow;
import top.shellteo.util.UUIDUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 2017/10/16.
 */
@Service("HomePageService")
public class HomePageServiceImpl extends BatisMapper implements HomePageService {
    private Logger logger = Logger.getLogger(HomePageServiceImpl.class);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public String getAllActivityLimit(String jsonData, String type) {
        logger.info("==>首页列表查询/搜索开始,入参:"+jsonData+",类型:"+type);
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
        logger.info("==>获取活动详细信息开始,入参;"+jsonData);
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
            logger.info("获取活动详细信息结束");
            return JSONObject.fromObject(new Response("0","","",bActivityPage)).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>获取活动详细信息失败:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    @Transactional
    public String joinActivity(String jsonData) {
        logger.info("==>参加活动开始,入参:"+jsonData);
        if (jsonData == null){
            return JSONObject.fromObject(new Response("1","","请检查入参","")).toString();
        }
        String openId = String.valueOf(JSONObject.fromObject(jsonData).get("openId"));
        String activityId = String.valueOf(JSONObject.fromObject(jsonData).get("activityId"));
        try{
            UUser uUser = uUserMapper.selectByPrimaryKey(openId);//若openid为""或者null,返回的uUser为null
            BActivity activity = bActivityMapper.selectByPrimaryKey(activityId);
            //不能参加自己的活动
            if (openId.equals(activity.getOpenid())){
                return JSONObject.fromObject(new Response("1","","不需要参加自己创建的活动","")).toString();
            }
            Date endDate = sdf.parse(activity.getEndtime());
            if (endDate.getTime()<=(new Date()).getTime()){
                return JSONObject.fromObject(new Response("1","","活动已结束","")).toString();
            }
            //校验用户是否已经参加该活动
            BJoinExample joinExample = new BJoinExample();
            BJoinExample.Criteria criteria = joinExample.createCriteria();
            criteria.andOpenidEqualTo(openId);
            criteria.andActivityidEqualTo(activityId);
            List<BJoin> bJoinList = bJoinMapper.selectByExample(joinExample);
            if (bJoinList.size()>=1){
                return JSONObject.fromObject(new Response("1","","您已参加此活动,请不要重复参加","")).toString();
            }

            //1.更新b_join表
            if (uUser == null || activity == null){
                return JSONObject.fromObject(new Response("1","","用户不存在或活动不存在,请核对入参","")).toString();
            }
            BJoin join = new BJoin();
            join.setOpenid(openId);
            join.setActivityid(activityId);
            join.setActivityname(activity.getActivityname());
            join.setNickname(uUser.getNickname());
            join.setUnionid(uUser.getUnionid());
            join.setStarttime(activity.getStarttime());
            join.setEndtime(activity.getEndtime());
            join.setCreatetime(new Date());
            bJoinMapper.insertSelective(join);

            //2.更新任务表,给参加者和创建活动者各增加一条待处理任务
            BTask taskJoin = new BTask();
            taskJoin.setOpenid(openId);
            taskJoin.setActivityid(activityId);
            taskJoin.setTasktype("2");//1:修改用户信息，2:参加某个活动，3:某某参加我的活动
            taskJoin.setCreatetime(ConstantShow.sdf.format(new Date()));
            bTaskMapper.insertSelective(taskJoin);
            BTask taskCreate = new BTask();
            taskCreate.setOpenid(activity.getOpenid());//活动创建者id
            taskCreate.setActivityid(activityId);
            taskCreate.setJoinopenid(openId);//活动参加者id
            taskCreate.setTasktype("3");
            taskCreate.setCreatetime(ConstantShow.sdf.format(new Date()));
            bTaskMapper.insertSelective(taskCreate);

            //3.给参加者产生定时任务,用于定时发送邮件提醒参加者参加活动
            BScheduleJob bScheduleJob = new BScheduleJob();
            String jobId = UUIDUtil.getUUID();
            String jobGroup = "joinActivity";
            String cronExpression = activity.getStarttime();//存放活动开始时间
            bScheduleJob.setJobid(jobId);
            bScheduleJob.setJobgroup(jobGroup);
            bScheduleJob.setType("1");
            bScheduleJob.setOpenid(openId);
            bScheduleJob.setJobstatus("");
            bScheduleJob.setTaskstatus("1");//新建
            bScheduleJob.setActivityid(activityId);
            bScheduleJob.setCronexpression(cronExpression);
            bScheduleJob.setDetail("");
            bScheduleJob.setEmail(uUser.getEmail());
            bScheduleJob.setTelephone(uUser.getTelphone());
            bScheduleJob.setCreatetime(new Date());
            bScheduleJobMapper.insertSelective(bScheduleJob);
            quartzManagerService.loadSchedule(bScheduleJob);//加载定时任务

            logger.info("==>参加活动结束");
            return JSONObject.fromObject(new Response("0","","","")).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("参加活动失败",e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    @Transactional
    public String createActivity(BActivityPage activity) {
        logger.info("==>开始创建活动,入参:"+JSONObject.fromObject(activity));
        String openId = activity.getOpenid();
        if (StringUtils.isBlank(openId)){
            return JSONObject.fromObject(new Response("1","","openId不能为空","")).toString();
        }
        if (uUserMapper.selectByPrimaryKey(openId) == null){
            return JSONObject.fromObject(new Response("1","","用户数据为空,请登录","")).toString();
        }
        if (StringUtils.isBlank(activity.getStarttime()) || StringUtils.isBlank(activity.getEndtime())){
            return JSONObject.fromObject(new Response("1","","活动开始时间和结束时间不能为空,请检查","")).toString();
        }

        BActivity bActivity = new BActivity();
        try{
            bActivity = (BActivity) BeanConvert.objConvertobj(activity,bActivity);
            bActivity.setCreatetime(new Date());
            bActivity.setActivityid(String.valueOf(new Date().getTime()));
            bActivityMapper.insertSelective(bActivity);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>创建活动失败",e);
        }
        logger.info("==>创建活动结束");
        return JSONObject.fromObject(new Response("0","","","")).toString();
    }
}
