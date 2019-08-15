package com.ly.senior.designpatterns.strategy.improve.impl;

import com.ly.senior.designpatterns.strategy.improve.QuackBehavior;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:37
 *  * @last modify by [luoyong 2019-08-15 15:37]
 * @Description: GeGeQuackBehavior
 **/
public class NoQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
