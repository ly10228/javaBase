package com.ly.senior.designpatterns.structured.bridge;

/**
 * @author luoyong
 * @Description: Vivo
 * @create 2019-09-14 16:32
 * @last modify by [LuoYong 2019-09-14 16:32]
 **/
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println(" Vivo手机开机 ");
    }

    @Override
    public void close() {
        System.out.println(" Vivo手机关机 ");
    }

    @Override
    public void call() {
        System.out.println(" Vivo手机打电话 ");
    }
}
