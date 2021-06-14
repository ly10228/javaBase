package com.ly.senior.designpatterns.sgg.structural.proxy.statics;

/**
 * @author luoyong
 *  * @create 2021-06-14 11:33 上午
 *  * @last modify by [luoyong 2021-06-14 11:33 上午]
 * @Description: 测试静态代理
 **/
public class MainTest {

    public static void main(String[] args) {
        LiMingTiktokProxy proxy = new LiMingTiktokProxy();
        proxy.setManTikTok(new ZhangTikTok());
        proxy.tiktok();
    }
}
