package top.shellteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellteo.service.MyNewsService;

/**
 * Created by HP on 2017/10/21.
 */
@Controller
@RequestMapping(value = "/mynews",method = RequestMethod.POST)
public class MyNewsController {
    @Autowired
    private MyNewsService myNewsService;

    @ResponseBody
    @RequestMapping(value = "/all")
    public String getNews(@RequestBody String jsonData){
        String res = myNewsService.getNews(jsonData);
        return res;
    };
}
