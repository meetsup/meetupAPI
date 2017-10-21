package top.shellteo.entity.mynewspage;

import top.shellteo.entity.UUserPage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HP on 2017/10/21.
 * 一种消息类型增加一个队列
 */
public class MyNewsPage implements Serializable {
    private List<UpdateUserInfo> userPageList;//修改用户信息  type 1
    private List<JoinActivityNews> joinActivityNewsList;//参加某个活动 type 2
    private List<JoinMyActivity> joinMyActivityList;//某某参加我的活动 type 3

    public List<UpdateUserInfo> getUserPageList() {
        return userPageList;
    }

    public void setUserPageList(List<UpdateUserInfo> userPageList) {
        this.userPageList = userPageList;
    }

    public List<JoinActivityNews> getJoinActivityNewsList() {
        return joinActivityNewsList;
    }

    public void setJoinActivityNewsList(List<JoinActivityNews> joinActivityNewsList) {
        this.joinActivityNewsList = joinActivityNewsList;
    }

    public List<JoinMyActivity> getJoinMyActivityList() {
        return joinMyActivityList;
    }

    public void setJoinMyActivityList(List<JoinMyActivity> joinMyActivityList) {
        this.joinMyActivityList = joinMyActivityList;
    }
}
