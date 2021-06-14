package com.ly.senior.designpatterns.sgg.creatation.factory.simplefactory;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:15 下午
 *  * @last modify by [luoyong 2021-06-14 3:15 下午]
 * @Description: 产品的抽象 --车 这边使用的是抽象类 也可以使用接口
 **/
public abstract class AbstractCar {
    String engine;

    public abstract void run();
}
