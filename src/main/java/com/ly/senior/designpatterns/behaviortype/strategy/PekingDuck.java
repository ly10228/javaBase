package com.ly.senior.designpatterns.behaviortype.strategy;

/**
 * @author luoyong
 *  * @create 2019-08-15 13:58
 *  * @last modify by [luoyong 2019-08-15 13:58]
 * @Description: PekingDuck
 **/
public class PekingDuck extends Duck {
    @Override
    public void display() {
        System.out.println("~~北京鸭~~~");
    }


    /**
     * @return void
     * @Description: 因为北京鸭不能飞翔，因此需要重写fly
     * @author luoyong
     * @create 13:58 2019-08-15
     * @last modify by [luoyong 13:58 2019-08-15 ]
     */
    @Override
    public void fly() {
        System.out.println("北京鸭不能飞翔");
    }

}
