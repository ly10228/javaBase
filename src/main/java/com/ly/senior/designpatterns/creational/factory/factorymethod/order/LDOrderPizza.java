package com.ly.senior.designpatterns.creational.factory.factorymethod.order;

import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.LDCheesePizza;
import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.LDPepperPizza;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:05
 *  * @last modify by [luoyong 2019-09-09 15:05]
 * @Description: LDOrderPizza
 **/
public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
