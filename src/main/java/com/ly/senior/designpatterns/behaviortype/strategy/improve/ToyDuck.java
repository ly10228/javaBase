package com.ly.senior.designpatterns.behaviortype.strategy.improve;

import com.ly.senior.designpatterns.behaviortype.strategy.improve.impl.NoFlyBehavior;
import com.ly.senior.designpatterns.behaviortype.strategy.improve.impl.NoQuackBehavior;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:41
 *  * @last modify by [luoyong 2019-08-15 15:41]
 * @Description: ToyDuck
 **/
public class ToyDuck extends Duck {

    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
        quackBehavior = new NoQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭");
    }

    @Override
    public void swim() {
        System.out.println("不会游泳");
    }
}
