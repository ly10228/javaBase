package com.ly.senior.designpatterns.creational.factory.simplefactory.order;

import com.ly.senior.designpatterns.creational.factory.simplefactory.SimpleFactory;

/**
 * @author luoyong
 * @Description: PizzaStore
 * @create 2019-09-08 23:55
 * @last modify by [LuoYong 2019-09-08 23:55]
 **/
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }
}
