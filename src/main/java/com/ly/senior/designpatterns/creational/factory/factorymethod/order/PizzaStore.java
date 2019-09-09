package com.ly.senior.designpatterns.creational.factory.factorymethod.order;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:07
 *  * @last modify by [luoyong 2019-09-09 15:07]
 * @Description: PizzaStore
 **/
public class PizzaStore {
    public static void main(String[] args) {
        String loc = "bj";
        if (loc.equals("bj")) {
            //创建北京口味的各种Pizza
            new BJOrderPizza();
        } else {
            //创建伦敦口味的各种Pizza
            new LDOrderPizza();
        }
    }

}
