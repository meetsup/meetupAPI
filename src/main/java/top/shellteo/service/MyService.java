package top.shellteo.service;

import top.shellteo.entity.UUserPage;

/**
 * Created by HP on 2017/10/17.
 */
public interface MyService {
    /**
     * 我的活动
     * @param jsonData
     * @return
     */
    String myActivities(String jsonData);

    /**
     * 我的信息
     * @param jsonData
     * @return
     */
    String myMessage(String jsonData);

    /**
     * 修改用户信息
     * @param jsonData
     * @return
     */
    String changeMesage(String jsonData);

    /**
     * 浏览历史
     * @param jsonData
     * @return
     */
    String scanHistory(String jsonData);

    /**
     * 修改用户信息
     * @param uUserPage
     * @return
     */
    String updateUserInfo(UUserPage uUserPage);
}
