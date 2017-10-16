package top.shellteo.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shellteo.entity.Response;
import top.shellteo.mapper.UTypeMapper;
import top.shellteo.mapper.UUserMapper;
import top.shellteo.pojo.UType;
import top.shellteo.pojo.UUser;
import top.shellteo.service.TypeService;

import java.util.List;

/**
 * Created by HP on 2017/10/16.
 */
@Service("TypeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private UUserMapper uUserMapper;
    @Autowired
    private UTypeMapper uTypeMapper;
    @Override
    public String AllType(String openId) {
        //1.判断用户是否已经登录
        UUser uUser = uUserMapper.selectByPrimaryKey(openId);
        if (uUser == null){
            return JSONObject.fromObject(new Response("1","","查询不到该用户数据,请重新登录","")).toString();
        }
        //2.查询所有数据返回
        List<UType> uTypes = uTypeMapper.selectByExample(null);
        String jsonData = JSONArray.fromObject(uTypes).toString();
        return JSONObject.fromObject(new Response("0","","",jsonData)).toString();
    }
}
