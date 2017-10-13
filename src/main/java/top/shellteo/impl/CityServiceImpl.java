package top.shellteo.impl;

import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        String res = "";
        try{
            List<UCity> uCityList = uCityMapper.selectByExample(null);
            res = JSONArray.fromObject(uCityList).toString();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return res;
    }
}
