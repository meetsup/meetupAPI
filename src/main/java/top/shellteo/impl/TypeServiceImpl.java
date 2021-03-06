package top.shellteo.impl;

import com.aliyun.oss.common.utils.LogUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shellteo.entity.Response;
import top.shellteo.mapper.UTypeMapper;
import top.shellteo.mapper.UUserMapper;
import top.shellteo.pojo.UType;
import top.shellteo.pojo.UUser;
import top.shellteo.service.TypeService;
import top.shellteo.util.BatisMapper;

import java.util.List;

/**
 * Created by HP on 2017/10/16.
 */
@Service("TypeService")
public class TypeServiceImpl extends BatisMapper implements TypeService {
    private final static Log logger = LogUtils.getLog();

    @Override
    public String AllType(String openId) {
        logger.info("==>类型查询开始");
        //1.判断用户是否已经登录
        UUser uUser = uUserMapper.selectByPrimaryKey(openId);
        if (uUser == null){
            logger.error("==>类型查询:查询不到该用户数据");
            return JSONObject.fromObject(new Response("1","","查询不到该用户数据,请重新登录","")).toString();
        }
        //2.查询所有数据返回
        List<UType> uTypes = uTypeMapper.selectByExample(null);
        JSONArray jsonData = JSONArray.fromObject(uTypes);
        logger.info("==>类型查询结束");
        return JSONObject.fromObject(new Response("0","","",jsonData)).toString();
    }
}
