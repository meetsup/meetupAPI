package top.shellteo.util;

import java.util.UUID;

/**
 * Created by HP on 2017/10/13.
 */
public class UUIDUtil {
    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
