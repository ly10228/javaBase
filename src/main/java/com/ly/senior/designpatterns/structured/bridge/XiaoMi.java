package com.ly.senior.designpatterns.structured.bridge;

/**
 * @author luoyong
 * @Description: XiaoMi
 * @create 2019-09-14 16:33
 * @last modify by [LuoYong 2019-09-14 16:33]
 **/
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println(" XiaoMi手机开机 ");
    }

    @Override
    public void close() {
        System.out.println(" XiaoMi手机关机 ");
    }

    @Override
    public void call() {
        System.out.println(" XiaoMi手机打电话 ");
    }
}
