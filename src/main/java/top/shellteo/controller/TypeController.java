package top.shellteo.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellteo.service.TypeService;

/**
 * Created by HP on 2017/10/16.
 * 类别
 */
@Controller
@RequestMapping(value = "/type",method = RequestMethod.POST)
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping(value = "/all")
    @ResponseBody
    public String AllType(@RequestBody String jsonData){
        String res = typeService.AllType(String.valueOf(JSONObject.fromObject(jsonData).get("openId")));
        return res;
    }
}
