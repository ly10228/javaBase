package com.ly.senior.designpatterns.structured.facade;

/**
 * @author luoyong
 * @Description: Popcorn
 * @create 2019-09-15 16:16
 * @last modify by [LuoYong 2019-09-15 16:16]
 **/
public class Popcorn {
    private static Popcorn popcorn = new Popcorn();

    public static Popcorn getInstance() {
        return popcorn;
    }

    public void on() {
        System.out.println(" popcorn on ");
    }

    public void off() {
        System.out.println(" popcorn ff ");
    }

    public void pop() {
        System.out.println(" popcorn is poping  ");
    }
}
