package com.ly.senior.designpatterns.structured.facade;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * 场景
 * 组建一个家庭影院：DVD播放器、投影仪、自动屏幕、环绕立体声、爆米花机,要求完成使用家庭影院的功能，其过程为：• 直接用遥控器：统筹各设备开关• 开爆米花机• 放下屏幕• 开投影仪• 开音响• 开DVD，选dvd• 去拿爆米花• 调暗灯光• 播放• 观影结束后，关闭各种设备
 * @create 2019-09-15 16:22
 * @last modify by [LuoYong 2019-09-15 16:22]
 **/
public class Client {

    @Test
    public void test() {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
        homeTheaterFacade.end();
    }
}
