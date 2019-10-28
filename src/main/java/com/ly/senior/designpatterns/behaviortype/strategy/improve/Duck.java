package com.ly.senior.designpatterns.behaviortype.strategy.improve;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2019-08-15 15:39
 *  * @last modify by [luoyong 2019-08-15 15:39]
 * @Description: Duck
 **/
@Data
public abstract class Duck {
    /**
     * 飞翔策略接口
     */
    FlyBehavior flyBehavior;

    /**
     * 叫声策略接口
     */
    QuackBehavior quackBehavior;

    public Duck() {

    }

    /**
     * 显示鸭子信息
     */
    public abstract void display();

    public void quack() {
        if (null != quackBehavior) {
            quackBehavior.quack();
        } else {
            System.out.println("鸭子嘎嘎叫~~");
        }
    }

    public void swim() {
        System.out.println("鸭子会游泳~~");
    }

    public void fly() {
        //改进
        if (flyBehavior != null) {
            flyBehavior.fly();
        } else {
            System.out.println("鸭子会飞翔~~~");
        }
    }

}
