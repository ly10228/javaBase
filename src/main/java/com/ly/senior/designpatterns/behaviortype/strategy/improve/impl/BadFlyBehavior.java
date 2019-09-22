package com.ly.senior.designpatterns.behaviortype.strategy.improve.impl;

import com.ly.senior.designpatterns.behaviortype.strategy.improve.FlyBehavior;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:33
 *  * @last modify by [luoyong 2019-08-15 15:33]
 * @Description: BadFlyBehavior
 **/
public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞翔技术一般");
    }
}
