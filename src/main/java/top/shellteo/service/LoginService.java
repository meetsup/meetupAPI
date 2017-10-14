package top.shellteo.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 2017/10/12.
 */
public interface LoginService {
    /**
     * 登录
     * @param js_code
     * @param request
     * @return
     */
    String login(String js_code, HttpServletRequest request);

    /**
     * 用户私密信息存储
     * @param savaJson
     * @param request
     * @return
     */
    String saveUser(String savaJson, HttpServletRequest request);
}
