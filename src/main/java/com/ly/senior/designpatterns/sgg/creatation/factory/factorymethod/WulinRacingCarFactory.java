package com.ly.senior.designpatterns.sgg.creatation.factory.factorymethod;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:33 下午
 *  * @last modify by [luoyong 2021-06-14 3:33 下午]
 * @Description: RacingCar分厂
 **/
public class WulinRacingCarFactory extends AbstractCarFactory {
    @Override
    public AbstractCar newCar() {
        return new RacingCar();
    }
}
