package com.ly.senior.designpatterns.behaviortype.strategy.improve.impl;

import com.ly.senior.designpatterns.behaviortype.strategy.improve.QuackBehavior;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:37
 *  * @last modify by [luoyong 2019-08-15 15:37]
 * @Description: GeGeQuackBehavior
 **/
public class GuaGuaQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("guagua叫");
    }
}
