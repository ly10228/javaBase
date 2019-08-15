package com.ly.senior.designpatterns.strategy.improve.impl;

import com.ly.senior.designpatterns.strategy.improve.FlyBehavior;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:32
 *  * @last modify by [luoyong 2019-08-15 15:32]
 * @Description: GoodFlyBehavior
 **/
public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞翔技术很好");
    }
}
