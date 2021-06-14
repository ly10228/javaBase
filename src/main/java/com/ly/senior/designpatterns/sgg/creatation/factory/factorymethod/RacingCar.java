package com.ly.senior.designpatterns.sgg.creatation.factory.factorymethod;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:34 下午
 *  * @last modify by [luoyong 2021-06-14 3:34 下午]
 * @Description: RacingCar
 **/
public class RacingCar extends AbstractCar {
    public RacingCar() {
        this.engine = "v8发动机";
    }

    @Override
    public void run() {
        System.out.println(engine + "=--嗖.....");
    }
}
