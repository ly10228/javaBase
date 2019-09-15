package com.ly.senior.designpatterns.structured.facade;

/**
 * @author luoyong
 * @Description: Stereo
 * @create 2019-09-15 16:19
 * @last modify by [LuoYong 2019-09-15 16:19]
 **/
public class Stereo {
    private static Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" Stereo on ");
    }

    public void off() {
        System.out.println(" Screen off ");
    }

    public void up() {
        System.out.println(" Screen up.. ");
    }

}
