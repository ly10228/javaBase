package com.ly.utils;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author sangxiaodong
 * @Description: Md5 工具
 * @create 2019-07-26 15:43
 * @last modify by [sangxiaodong 2019-07-26 15:43]
 **/
public class MD5Util {

    public static String getMd5(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(str.getBytes());
            byte[] var4 = bs;
            int var5 = bs.length;
            for (int var6 = 0; var6 < var5; ++var6) {
                byte x = var4[var6];
                if ((x & 255) >> 4 == 0) {
                    sb.append("0").append(Integer.toHexString(x & 255));
                } else {
                    sb.append(Integer.toHexString(x & 255));
                }
            }
        } catch (NoSuchAlgorithmException var8) {
//            log.warn("var8:{}", var8);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String appKey = "gdym_zhs";
        String appSecret = "gdym_secret";

//        String appKey = "zhongan_zhs_saas";
//        String appSecret = "saas_app_secret";
        long current = System.currentTimeMillis();
        System.out.println(current);
        String sign = appSecret + current;
        System.out.println(getMd5(sign));

    }

    @Test
    public void test() {
        List<String> phoneList = Lists.newArrayList();
        phoneList.add("18621043035");
        phoneList.add("18621043035");
        phoneList.add("13723123035");

        List<String> newAddStringList = CommonUtils.getDuplicateElements(phoneList);
        newAddStringList.stream().forEach(System.out::println);
    }

}

