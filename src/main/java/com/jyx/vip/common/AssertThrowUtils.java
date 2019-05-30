package com.jyx.vip.common;

/**
 * @author:jyx
 * @date:2019-05-29 17:15
 * @desc(描述):
 */
public class AssertThrowUtils {

    public static String throwIsNull(String message, String target) {
        if (target == null || (target = target.trim()).length() == 0) {
            throw new ThisSystemException(message);
        }

        return target;
    }

    public static void throwSystemException(String message) {
        if (message != null) {
            throw new ThisSystemException(message);
        }
    }

    public static void assertNotNull(String message,Object o){
        if (o == null){
           throw new ThisSystemException(message);
        }
    }

    public static void assertNull(String message,Object o){
        if (o != null){
            throw new ThisSystemException(message);
        }
    }

    public static void assertEquals(String message,Object a,Object b){
        if (a == null?a!=b:!a.equals(b)){
            throw new ThisSystemException(message);
        }
    }

    public static void assertNotEquals(String message,Object a,Object b){
        if (a == null?a==b:a.equals(b)){
            throw new ThisSystemException(message);
        }
    }
}
