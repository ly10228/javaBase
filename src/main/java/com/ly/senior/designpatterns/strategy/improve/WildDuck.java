package com.ly.senior.designpatterns.strategy.improve;

import com.ly.senior.designpatterns.strategy.improve.impl.GeGeQuackBehavior;
import com.ly.senior.designpatterns.strategy.improve.impl.GoodFlyBehavior;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:48
 *  * @last modify by [luoyong 2019-08-15 15:48]
 * @Description: WildDuck
 **/
public class WildDuck extends Duck {

    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new GeGeQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是一个野鸭");
    }

}
