package com.ly.senior.designpatterns.strategy;

/**
 * @author luoyong
 *  * @create 2019-08-15 13:52
 *  * @last modify by [luoyong 2019-08-15 13:52]
 * @Description: Duck 鸭子问题
 **/
public abstract class Duck {
    public Duck() {

    }

    /**
     * @return void
     * @Description: 显示鸭子信息
     * @author luoyong
     * @create 13:53 2019-08-15
     * @last modify by [luoyong 13:53 2019-08-15 ]
     */
    public abstract void display();

    public void quack() {
        System.out.println("鸭子嘎嘎叫~~");
    }

    public void swim() {
        System.out.println("鸭子会游泳~~");
    }

    public void fly() {
        System.out.println("鸭子会飞翔~~~");
    }
}
