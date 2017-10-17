package top.shellteo.util;

import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by HP on 2017/10/17.
 */
public class BeanConvert {
    /**
     * 将source对象转换为obj对象,属性相同
     * @param source
     * @param obj
     * @return
     * @throws Exception
     */
    public static Object objConvertobj(Object source,Object obj) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map map = (Map) JSONObject.fromObject(source);
        //遍历所有属性,将date转换为字符串
        Field[] fields = obj.getClass().getDeclaredFields();//获取所有属性
        for (int i=0; i<fields.length; i++){
            String name = fields[i].getName();//获取属性名称
            String nameNew = name.substring(0,1).toUpperCase()+name.substring(1);//首字母大写,方便构造get/set方法
            String type = fields[i].getGenericType().toString();//获取属性类型
            Method get = obj.getClass().getMethod("get"+nameNew);//获取get方法
            if (type.equals("class java.lang.String")){
                Method set = obj.getClass().getMethod("set"+nameNew,String.class);//获取set方法
                if (map.get(name)!=null && map.get(name) instanceof String){
                    set.invoke(obj,(String)map.get(name));
                }
            }
        }
        return obj;
    }
}
