package top.shellteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellteo.service.CityService;

/**
 * Created by HP on 2017/10/9.
 */
@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/findCity",method = RequestMethod.GET)
    @ResponseBody
    public String findCity(){
        String citys = cityService.findAllCity();
        return citys;
    }
}
