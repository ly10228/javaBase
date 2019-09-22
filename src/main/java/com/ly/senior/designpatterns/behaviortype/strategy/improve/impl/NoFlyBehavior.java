package com.ly.senior.designpatterns.behaviortype.strategy.improve.impl;

import com.ly.senior.designpatterns.behaviortype.strategy.improve.FlyBehavior;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:34
 *  * @last modify by [luoyong 2019-08-15 15:34]
 * @Description: NoFlyBehavior
 **/
public class NoFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("不会飞翔");
    }
}
