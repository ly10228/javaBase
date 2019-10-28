package com.ly.senior.designpatterns.behaviortype.strategy;

/**
 * @author luoyong
 *  * @create 2019-08-15 13:57
 *  * @last modify by [luoyong 2019-08-15 13:57]
 * @Description: ToyDuck
 **/
public class ToyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("玩具鸭");
    }

    //需要重写父类的所有方法

    public void quack() {
        System.out.println("玩具鸭不能叫~~");
    }

    public void swim() {
        System.out.println("玩具鸭不会游泳~~");
    }

    public void fly() {
        System.out.println("玩具鸭不会飞翔~~~");
    }
}
