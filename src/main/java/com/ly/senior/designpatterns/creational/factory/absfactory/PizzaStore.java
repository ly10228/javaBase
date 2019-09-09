package com.ly.senior.designpatterns.creational.factory.absfactory;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:22
 *  * @last modify by [luoyong 2019-09-09 15:22]
 * @Description: PizzaStore
 **/
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza(new LDCreatePizzaImpl());
    }
}
