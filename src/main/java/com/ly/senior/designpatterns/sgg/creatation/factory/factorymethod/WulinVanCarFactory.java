package com.ly.senior.designpatterns.sgg.creatation.factory.factorymethod;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:35 下午
 *  * @last modify by [luoyong 2021-06-14 3:35 下午]
 * @Description: 卡车分厂
 **/
public class WulinVanCarFactory extends AbstractCarFactory {
    @Override
    public AbstractCar newCar() {
        return new VanCar();
    }
}
