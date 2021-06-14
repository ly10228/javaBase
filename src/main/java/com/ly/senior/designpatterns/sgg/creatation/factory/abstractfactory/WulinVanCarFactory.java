package com.ly.senior.designpatterns.sgg.creatation.factory.abstractfactory;

/**
 * 分厂：VanCar
 */
public class WulinVanCarFactory extends WulinCarFactory {
    @Override
    AbstractCar newCar() {
        return new VanCar();
    }

}
