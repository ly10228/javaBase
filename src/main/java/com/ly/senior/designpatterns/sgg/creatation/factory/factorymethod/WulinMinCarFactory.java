package com.ly.senior.designpatterns.sgg.creatation.factory.factorymethod;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:32 下午
 *  * @last modify by [luoyong 2021-06-14 3:32 下午]
 * @Description: mini分厂
 **/
public class WulinMinCarFactory extends AbstractCarFactory {
    @Override
    public AbstractCar newCar() {
        return new MiniCar();
    }
}
