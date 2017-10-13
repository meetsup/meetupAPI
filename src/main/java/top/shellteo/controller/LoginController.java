package top.shellteo.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellteo.service.LoginService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 2017/10/12.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String json, HttpServletRequest request){
        String res = loginService.login(String.valueOf(JSONObject.fromObject(json).get("js_code")),request);
        return res;
    }
}
