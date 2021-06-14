package com.ly.senior.designpatterns.sgg.creatation.factory.abstractfactory;

import java.util.List;

/**
 * 总厂规范：
 * Wulin集团
 * <p>
 * 使用接口；
 */
public abstract class WulinFactory {

    List<String> rules;

    abstract AbstractCar newCar();

    abstract AbstractMask newMask();
}
