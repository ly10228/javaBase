package com.ly.senior.designpatterns.structured.facade;

/**
 * @author luoyong
 * @Description: DVDPlayer
 * @create 2019-09-15 16:13
 * @last modify by [LuoYong 2019-09-15 16:13]
 **/
public class DVDPlayer {
    /**
     * 单例模式,使用饿汉式--静态变量 在装载类的时候就会被初始化
     */
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" dvd on ");
    }

    public void off() {
        System.out.println(" dvd off ");
    }

    public void play() {
        System.out.println(" dvd is playing ");
    }

    public void pause() {
        System.out.println(" dvd pause ..");
    }
}
