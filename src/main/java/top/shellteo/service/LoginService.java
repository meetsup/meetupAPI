package top.shellteo.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 2017/10/12.
 */
public interface LoginService {
    String login(String js_code, HttpServletRequest request);
}
