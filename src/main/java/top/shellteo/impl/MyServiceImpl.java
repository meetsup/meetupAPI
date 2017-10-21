package top.shellteo.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.shellteo.entity.BActivityPage;
import top.shellteo.entity.BJoinPage;
import top.shellteo.entity.Response;
import top.shellteo.entity.UUserPage;
import top.shellteo.mapper.BActivityMapper;
import top.shellteo.mapper.BJoinMapper;
import top.shellteo.mapper.BTaskMapper;
import top.shellteo.mapper.UUserMapper;
import top.shellteo.pojo.*;
import top.shellteo.service.MyService;
import top.shellteo.util.BatisMapper;
import top.shellteo.util.BeanConvert;
import top.shellteo.util.ConstantShow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by HP on 2017/10/17.
 */
@Service("MyService")
public class MyServiceImpl extends BatisMapper implements MyService {
    private static Logger logger = Logger.getLogger(MyServiceImpl.class);

    @Override
    public String myActivities(String jsonData) {
        logger.info("==>我的活动查询开始,入参:"+jsonData);
        if (StringUtils.isBlank(jsonData)){
            return JSONObject.fromObject(new Response("1","","入参为空,请检查","")).toString();
        }
        String openId = JSONObject.fromObject(jsonData).get("openId").toString();
        if (uUserMapper.selectByPrimaryKey(openId) == null){
            return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
        }
        List<BJoinPage> bJoinPageList = new ArrayList<BJoinPage>();
        try{
            BJoinExample bJoinExample = new BJoinExample();
            bJoinExample.setOrderByClause("CreateTime DESC");
            BJoinExample.Criteria criteria = bJoinExample.createCriteria();
            criteria.andOpenidEqualTo(openId);
            List<BJoin> bJoinList = bJoinMapper.selectByExample(bJoinExample);
            for (BJoin bJoin : bJoinList){
                BJoinPage bJoinPage = new BJoinPage();
                bJoinPage = (BJoinPage) BeanConvert.objConvertobj(bJoin,bJoinPage);
                bJoinPageList.add(bJoinPage);
            }

            JSONArray res = JSONArray.fromObject(bJoinPageList);
            logger.info("==>我的活动查询结束");
            return JSONObject.fromObject(new Response("0","","",res)).toString();
        }catch (Exception e){
            logger.error("==>我的活动查询错误,错误信息:"+e);
            e.printStackTrace();
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    public String myMessage(String jsonData) {
        logger.info("==>我的信息查询开始,入参:"+jsonData);
        if (StringUtils.isBlank(jsonData)){
            return JSONObject.fromObject(new Response("1","","入参为空,请检查","")).toString();
        }
        String openId = JSONObject.fromObject(jsonData).get("openId").toString();
        try{
            UUser uUser = uUserMapper.selectByPrimaryKey(openId);
            if (uUser == null){
                return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
            }
            UUserPage uUserPage = new UUserPage();
            uUserPage = (UUserPage) BeanConvert.objConvertobj(uUser,uUserPage);
            logger.info("==>我的信息查询结束");
            return JSONObject.fromObject(new Response("0","","",JSONObject.fromObject(uUserPage))).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>我的信息查询错误,详细信息:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    @Transactional
    public String changeMesage(String jsonData) {
        logger.info("==>修改用户信息开始,入参:"+jsonData);
        if (StringUtils.isBlank(jsonData)){
            return JSONObject.fromObject(new Response("1","","入参为空,请检查","")).toString();
        }
        try{
            UUserPage uUserPage = (UUserPage) JSONObject.toBean(JSONObject.fromObject(jsonData),UUserPage.class);
            if (uUserMapper.selectByPrimaryKey(uUserPage.getOpenid()) == null){ //openid 为null,需要测试
                return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
            }
            UUser uUser = new UUser();
            uUser = (UUser) BeanConvert.objConvertobj(uUserPage,uUser);
            uUser.setUpdatetime(new Date());
            uUserMapper.updateByPrimaryKeySelective(uUser);
            logger.info("==>修改用户信息结束");
            return JSONObject.fromObject(new Response("0","","","")).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>修改用户信息错误,详细信息:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    public String scanHistory(String jsonData) {
        logger.info("==>浏览历史查询开始,入参:"+jsonData);
        if (StringUtils.isBlank(jsonData)){
            return JSONObject.fromObject(new Response("1","","入参为空,请检查","")).toString();
        }
        String openId = JSONObject.fromObject(jsonData).get("openId").toString();
        if (uUserMapper.selectByPrimaryKey(openId) == null){
            return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
        }
        List<Object> objects = new ArrayList<Object>();
        try{
            //1.我参与的活动
            BJoinExample example = new BJoinExample();
            BJoinExample.Criteria criteria = example.createCriteria();
            criteria.andOpenidEqualTo(openId);
            List<BJoin> bJoinList = bJoinMapper.selectByExample(example);
           // List<BJoinPage> bJoinPageList = new ArrayList<BJoinPage>();
            for (BJoin bJoin : bJoinList){
                BActivity bActivity = bActivityMapper.selectByPrimaryKey(bJoin.getActivityid());
                BActivityPage bActivityPage = new BActivityPage();
                bActivityPage = (BActivityPage) BeanConvert.objConvertobj(bActivity,bActivityPage);
                Object object = JSONObject.fromObject(bActivityPage).accumulate("attr","join");//新增属性,join表示我参与的活动
                objects.add(object);
            }
            //2.我创办的活动
            BActivityExample example1 = new BActivityExample();
            BActivityExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andOpenidEqualTo(openId);
            List<BActivity> bActivityList = bActivityMapper.selectByExampleWithBLOBs(example1);
            for (BActivity bActivity : bActivityList){
                BActivityPage bActivityPage = new BActivityPage();
                bActivityPage = (BActivityPage) BeanConvert.objConvertobj(bActivity,bActivityPage);
                Object object = JSONObject.fromObject(bActivityPage).accumulate("attr","create");//create表示我创建的活动
                objects.add(object);
            }
            logger.info("==>浏览历史查询结束");
            return JSONObject.fromObject(new Response("0","","",JSONArray.fromObject(objects))).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>浏览历史查询错误,详细信息:"+e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }

    @Override
    @Transactional
    public String updateUserInfo(UUserPage uUserPage) {
        logger.info("==>开始修改用户信息,入参:"+JSONObject.fromObject(uUserPage).toString());
        if (StringUtils.isBlank(uUserPage.getOpenid())){
            return JSONObject.fromObject(new Response("1","","openId为空,请检查参数","")).toString();
        }
        if (uUserMapper.selectByPrimaryKey(uUserPage.getOpenid()) == null){
            return JSONObject.fromObject(new Response("1","","用户数据不存在,请登录","")).toString();
        }
        UUser uUser = new UUser();
        try{
            uUser = (UUser) BeanConvert.objConvertobj(uUserPage,uUser);
            uUser.setUpdatetime(new Date());
            int count = uUserMapper.updateByPrimaryKeySelective(uUser);
            //修改用户数据成功之后给用户生成一条待处理任务
            if (count > 0){
                BTask task = new BTask();
                task.setOpenid(uUserPage.getOpenid());
                task.setTasktype("1");//1:修改用户信息，2:参加某个活动，3:某某参加我的活动
                task.setCreatetime(ConstantShow.sdf.format(new Date()));
                bTaskMapper.insertSelective(task);
                logger.info("==>修改用户信息结束");
            }
        }catch (Exception e){
            logger.error("修改用户信息失败",e);
            e.printStackTrace();
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
        return JSONObject.fromObject(new Response("0","","","")).toString();
    }
}
