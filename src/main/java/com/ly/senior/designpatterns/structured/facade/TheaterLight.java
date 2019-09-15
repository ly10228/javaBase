package com.ly.senior.designpatterns.structured.facade;

/**
 * @author luoyong
 * @Description: TheaterLight
 * @create 2019-09-15 16:19
 * @last modify by [LuoYong 2019-09-15 16:19]
 **/
public class TheaterLight {
    private static TheaterLight instance = new TheaterLight();

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" TheaterLight on ");
    }

    public void off() {
        System.out.println(" TheaterLight off ");
    }

    public void dim() {
        System.out.println(" TheaterLight dim.. ");
    }

    public void bright() {
        System.out.println(" TheaterLight bright.. ");
    }
}
