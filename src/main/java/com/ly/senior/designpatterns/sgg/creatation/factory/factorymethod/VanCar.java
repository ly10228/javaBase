package com.ly.senior.designpatterns.sgg.creatation.factory.factorymethod;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:17 下午
 *  * @last modify by [luoyong 2021-06-14 3:17 下午]
 * @Description: VanCar
 **/
public class VanCar extends AbstractCar {
    public VanCar() {
        this.engine = "单杠柴油机";
    }

    @Override
    public void run() {
        System.out.println(engine + "--》嗒嗒嗒....");
    }
}
