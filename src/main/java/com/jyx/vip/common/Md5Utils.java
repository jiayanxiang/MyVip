package com.jyx.vip.common;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author:jyx
 * @date:2019/5/27 10:19
 * @desc(描述):
 */
public class Md5Utils<main> {
    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param origin 字符
     * @return
     */
    public static String MD5Encode(String origin) {
        return MD5Encode(origin, "UTF-8");//默认编码utf-8
    }

    /**
     * MD5加密
     *
     * @param origin      字符
     * @param charsetname 编码
     * @return
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetname || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }

    private static String getMd5(String strInput){
        BigInteger bigInteger = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = strInput.getBytes();
            messageDigest.update(bytes);
            bigInteger = new BigInteger(messageDigest.digest());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bigInteger.toString(16);
    }

    //测试
    public static void main(String[] args) {
        String wdf = MD5Encode("123");
        System.out.println(wdf);
        System.out.println(getMd5("123"));
    }
}
