package top.shellteo.impl;

import com.aliyun.oss.common.utils.LogUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shellteo.entity.Response;
import top.shellteo.mapper.UCityMapper;
import top.shellteo.pojo.UCity;
import top.shellteo.service.CityService;
import top.shellteo.util.BatisMapper;

import java.util.List;

/**
 * Created by HP on 2017/10/9.
 */
@Service("CityService")
public class CityServiceImpl extends BatisMapper implements CityService {
    private final static Log logger = LogUtils.getLog();

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
