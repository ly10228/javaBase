package com.ly.senior.designpatterns.structured.facade;

/**
 * @author luoyong
 * @Description: Screen
 * @create 2019-09-15 16:18
 * @last modify by [LuoYong 2019-09-15 16:18]
 **/
public class Screen {
    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println(" Screen up ");
    }

    public void down() {
        System.out.println(" Screen down ");
    }
}
