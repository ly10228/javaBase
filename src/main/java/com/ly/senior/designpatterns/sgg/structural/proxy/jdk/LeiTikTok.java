package com.ly.senior.designpatterns.sgg.structural.proxy.jdk;

/**
 * @author luoyong
 *  * @create 2021-06-14 11:38 上午
 *  * @last modify by [luoyong 2021-06-14 11:38 上午]
 * @Description: 被代理对象
 **/
public class LeiTikTok implements ManTikTok, SellTikTok {
    @Override
    public void tiktok() {
        System.out.println("雷丰阳，tiktok.... ");
    }

    @Override
    public void sell() {
        System.out.println("雷丰阳，只要666，赶紧来包...");
    }

    public void haha() {
        System.out.println("hahaha ,......");
    }
}
