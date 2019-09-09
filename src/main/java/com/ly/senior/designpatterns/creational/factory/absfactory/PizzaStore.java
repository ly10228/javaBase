package com.ly.senior.designpatterns.creational.factory.absfactory;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:22
 *  * @last modify by [luoyong 2019-09-09 15:22]
 * @Description: PizzaStore 抽象工厂模式可以将简单工厂模式和工厂方法模式进行整合
 **/
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza(new LDCreatePizzaImpl());
    }
}
