package top.shellteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellteo.entity.BActivityPage;
import top.shellteo.service.HomePageService;

/**
 * Created by HP on 2017/10/16.
 * 首页
 */
@Controller
@RequestMapping(value = "/homepage",method = RequestMethod.POST)
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @RequestMapping(value = "/listActivity")
    @ResponseBody
    public String allActivity(@RequestBody String jsondata){
        String type = "list";
        String res = homePageService.getAllActivityLimit(jsondata,type);
        return res;
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public String detailActivity(@RequestBody String jsonData){
        String res = homePageService.getDetail(jsonData);
        return res;
    }

    @RequestMapping(value = "/search")
    @ResponseBody
    public String search(@RequestBody String jsondata){
        String type = "search";
        String res = homePageService.getAllActivityLimit(jsondata,type);
        return res;
    }

    @RequestMapping(value = "/join")
    @ResponseBody
    public String join(@RequestBody String jsondata){
        String res = homePageService.joinActivity(jsondata);
        return res;
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public String createActivity(BActivityPage activity){
        String res = homePageService.createActivity(activity);
        return res;
    }

}
