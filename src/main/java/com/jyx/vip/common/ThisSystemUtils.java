package com.jyx.vip.common;

import java.util.UUID;

/**
 * @author:jyx
 * @date:2019-05-30 9:38
 * @desc(描述):
 */
public class ThisSystemUtils {
    public static int parseInt(String target,int defaultValue){
        try {
            return Integer.parseInt(target.trim());
        }catch (Exception e){
            return defaultValue;
        }
    }

    public static String uid(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-","").trim();
        return uuid;
    }
}
