package com.ly.senior.designpatterns.sgg.creatation.factory.factorymethod;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:16 下午
 *  * @last modify by [luoyong 2021-06-14 3:16 下午]
 * @Description: MiniCar
 **/
public class MiniCar extends AbstractCar {
    public MiniCar() {
        this.engine = "四缸水平对置发动机";
    }

    @Override
    public void run() {
        System.out.println(engine + "--> 嘟嘟嘟...");
    }
}
