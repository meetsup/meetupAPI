package top.shellteo.impl;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import top.shellteo.entity.Response;
import top.shellteo.entity.mynewspage.JoinActivityNews;
import top.shellteo.entity.mynewspage.JoinMyActivity;
import top.shellteo.entity.mynewspage.MyNewsPage;
import top.shellteo.entity.mynewspage.UpdateUserInfo;
import top.shellteo.pojo.BActivity;
import top.shellteo.pojo.BTask;
import top.shellteo.pojo.BTaskExample;
import top.shellteo.pojo.UUser;
import top.shellteo.service.MyNewsService;
import top.shellteo.util.BatisMapper;
import top.shellteo.util.BeanConvert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2017/10/21.
 */
@Service("MyNewsService")
public class MyNewsServiceImpl extends BatisMapper implements MyNewsService {
    private Logger logger = Logger.getLogger(MyNewsServiceImpl.class);

    @Override
    public String getNews(String jsonData) {
        logger.info("==>获取我的信息列表开始");
        try{
            String openId = JSONObject.fromObject(jsonData).get("openId").toString();

            if (StringUtils.isBlank(openId)){
                return JSONObject.fromObject(new Response("1","","请检查入参","")).toString();
            }
            UUser uUser = uUserMapper.selectByPrimaryKey(openId);
            if (uUser == null){
                return JSONObject.fromObject(new Response("1","","用户数据不存在,请先登录","")).toString();
            }

            //查出type2/type3所有数据,根据类型赋值
            BTaskExample taskExample = new BTaskExample();
            BTaskExample.Criteria criteria = taskExample.createCriteria();
            criteria.andIsdeleteEqualTo("N");//必须是没有被删除的数据
            criteria.andTasktypeNotEqualTo("1");
            criteria.andOpenidEqualTo(openId);
            List<BTask> taskList = bTaskMapper.selectByExample(taskExample);
            //查出type1数据,type1只取一个数据,特殊,单独查询
            BTaskExample taskExample1 = new BTaskExample();
            BTaskExample.Criteria criteria1 = taskExample1.createCriteria();
            criteria1.andIsdeleteEqualTo("N");
            criteria1.andTasktypeEqualTo("1");
            criteria1.andOpenidEqualTo(openId);
            taskExample1.setOrderByClause("CreateTime DESC");
            List<BTask> taskList1 = bTaskMapper.selectByExample(taskExample1);//获取第一个即为最新值

            MyNewsPage myNewsPage = new MyNewsPage();
            List<UpdateUserInfo> updateUserInfoList = new ArrayList<UpdateUserInfo>();//type 1
            List<JoinActivityNews> joinActivityNewsList = new ArrayList<JoinActivityNews>();//type 2
            List<JoinMyActivity> joinMyActivityList = new ArrayList<JoinMyActivity>();//type 3

            if (taskList1.size()>0){
                BTask task = taskList1.get(0);//获取最新数据
                UpdateUserInfo updateUserInfo = new UpdateUserInfo();
                updateUserInfo = (UpdateUserInfo) BeanConvert.objConvertobj(uUser,updateUserInfo);
                updateUserInfo.setId(task.getId());
                updateUserInfo.setTasktype(task.getTasktype());
                updateUserInfo.setCreatetime(task.getCreatetime());
                updateUserInfoList.add(updateUserInfo);
            }
            if (taskList.size()>0){
                for (BTask task : taskList){
                    String activityId = task.getActivityid();
                    //type2/type3 需要
                    BActivity activity = new BActivity();
                    UUser userActivity = new UUser();//活动创建者的用户信息
                    if (StringUtils.isNotBlank(activityId)){
                        activity = bActivityMapper.selectByPrimaryKey(activityId);
                        userActivity = uUserMapper.selectByPrimaryKey(activity.getOpenid());
                    }

                    if ("2".equals(task.getTasktype())){    //参加活动
                        JoinActivityNews joinActivityNews = new JoinActivityNews();
                        joinActivityNews = (JoinActivityNews) BeanConvert.objConvertobj(activity,joinActivityNews);
                        //组装活动创建者信息
                        joinActivityNews.setCreatephone(userActivity.getTelphone());
                        joinActivityNews.setCreatemail(userActivity.getEmail());
                        //组装参加者信息
                        joinActivityNews.setOpenid(openId);
                        joinActivityNews.setNickname(uUser.getNickname());
                        //组装消息部分信息
                        joinActivityNews.setId(task.getId());
                        joinActivityNews.setTasktype(task.getTasktype());
                        joinActivityNews.setCreatetime(task.getCreatetime());
                        joinActivityNewsList.add(joinActivityNews);
                    }
                    if ("3".equals(task.getTasktype())){    //某某参加我的活动
                        //组装活动部分信息
                        JoinMyActivity joinMyActivity = new JoinMyActivity();
                        joinMyActivity = (JoinMyActivity) BeanConvert.objConvertobj(activity,joinMyActivity);
                        //活动创建者信息
                        joinMyActivity.setNicknameCreate(userActivity.getNickname());
                        //参加者部分信息
                        joinMyActivity = (JoinMyActivity) BeanConvert.objConvertobj(uUserMapper.selectByPrimaryKey(task.getJoinopenid()),joinMyActivity);
                        //消息部分信息
                        joinMyActivity.setId(task.getId());
                        joinMyActivity.setTasktype(task.getTasktype());
                        joinMyActivity.setCreatetime(task.getCreatetime());
                        joinMyActivityList.add(joinMyActivity);
                    }
                }
            }
            myNewsPage.setUserPageList(updateUserInfoList);
            myNewsPage.setJoinActivityNewsList(joinActivityNewsList);
            myNewsPage.setJoinMyActivityList(joinMyActivityList);
            logger.info("==>获取我的信息列表结束");
            return JSONObject.fromObject(new Response("0","","",JSONObject.fromObject(myNewsPage))).toString();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("==>获取我的信息列表失败",e);
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
    }
}
