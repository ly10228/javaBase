package com.ly.senior.designpatterns.sgg.structural.proxy.cglib;

/**
 * @author luoyong
 *  * @create 2021-06-14 12:05 下午
 *  * @last modify by [luoyong 2021-06-14 12:05 下午]
 * @Description: test
 **/
public class MainTest {
    public static void main(String[] args) {

        LeiTikTok proxy = CglibProxy.createProxy(new LeiTikTok());
        proxy.tiktokHaha();
    }
}
