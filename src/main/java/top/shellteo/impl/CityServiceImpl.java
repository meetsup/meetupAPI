package top.shellteo.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shellteo.entity.Response;
import top.shellteo.mapper.UCityMapper;
import top.shellteo.pojo.UCity;
import top.shellteo.service.CityService;

import java.util.List;

/**
 * Created by HP on 2017/10/9.
 */
@Service("CityService")
public class CityServiceImpl implements CityService {
    private static final Logger logger = Logger.getLogger(CityServiceImpl.class);
    @Autowired
    private UCityMapper uCityMapper;

    public String findAllCity() {
        JSONArray res = null;
        try{
            List<UCity> uCityList = uCityMapper.selectByExample(null);
            res = JSONArray.fromObject(uCityList);
        }catch (Exception e){
            logger.error(e.getMessage());
            return JSONObject.fromObject(new Response("1","",e.getMessage(),"")).toString();
        }
        return JSONObject.fromObject(new Response("0","","",res)).toString();
    }
}
