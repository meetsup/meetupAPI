package top.shellteo.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellteo.entity.UUserPage;
import top.shellteo.service.MyService;

/**
 * Created by HP on 2017/10/17.
 */
@Controller
@RequestMapping(value = "/my",method = RequestMethod.POST)
public class MyController {
    @Autowired
    private MyService myService;

    @ResponseBody
    @RequestMapping(value = "/activity")
    public String myActivities(@RequestBody String jsondata){
        String res = myService.myActivities(jsondata);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/message")
    public String myMessage(@RequestBody String jsondata){
        String res = myService.myMessage(jsondata);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/change")
    public String changeMessage(@RequestBody String jsondata){
        String res = myService.changeMesage(jsondata);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/history")
    public String scanMessage(@RequestBody String jsondata){
        String res = myService.scanHistory(jsondata);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserInfo")
    public String scanMessage(@RequestBody UUserPage userPage){
        String res = myService.updateUserInfo(userPage);
        return res;
    }
}
