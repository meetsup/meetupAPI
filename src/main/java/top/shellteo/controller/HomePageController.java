package top.shellteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellteo.service.HomePageService;

/**
 * Created by HP on 2017/10/16.
 */
@Controller
@RequestMapping(value = "/homepage",method = RequestMethod.POST)
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @RequestMapping(value = "/listActivity")
    @ResponseBody
    public String allActivity(@RequestBody String jsondata){
        String res = homePageService.getAllActivityLimit(jsondata);
        return res;
    }
}
