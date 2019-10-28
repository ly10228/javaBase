package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: LightReceiver
 * @create 2019-09-16 22:49
 * @last modify by [LuoYong 2019-09-16 22:49]
 **/
public class LightReceiver {
    public void on() {
        System.out.println(" 电灯打开了.. ");
    }

    public void off() {
        System.out.println(" 电灯关闭了.. ");
    }
}
