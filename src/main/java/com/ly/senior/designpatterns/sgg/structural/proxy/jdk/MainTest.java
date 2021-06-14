package com.ly.senior.designpatterns.sgg.structural.proxy.jdk;

import java.util.Arrays;

/**
 * @author luoyong
 *  * @create 2021-06-14 11:51 上午
 *  * @last modify by [luoyong 2021-06-14 11:51 上午]
 * @Description: test
 * 动态代理模式：
 * JDK要求被代理对象必须有接口
 * 代理对象和目标对象的相同点在于都是同一个接口
 **/
public class MainTest {
    public static void main(String[] args) {

        /**
         * 动态代理机制。
         */
        ManTikTok proxy = JdkTiktokProxy.getProxy(new LeiTikTok());
        proxy.tiktok();

        ((SellTikTok) proxy).sell();


        //能不能代理被代理对象本类自己的方法?proxy只能转成接口类
//        ((LeiTikTok)proxy).haha();
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
    }
}
