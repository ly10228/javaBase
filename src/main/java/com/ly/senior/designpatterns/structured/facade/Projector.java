package com.ly.senior.designpatterns.structured.facade;

/**
 * @author luoyong
 * @Description: Projector
 * @create 2019-09-15 16:18
 * @last modify by [LuoYong 2019-09-15 16:18]
 **/
public class Projector {
    private static Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" Projector on ");
    }

    public void off() {
        System.out.println(" Projector ff ");
    }

    public void focus() {
        System.out.println(" Projector is Projector  ");
    }
}
