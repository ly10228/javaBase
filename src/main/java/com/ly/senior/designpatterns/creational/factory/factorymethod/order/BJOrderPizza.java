package com.ly.senior.designpatterns.creational.factory.factorymethod.order;

import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.BJCheesePizza;
import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.BJPepperPizza;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:04
 *  * @last modify by [luoyong 2019-09-09 15:04]
 * @Description: BJOrderPizza
 **/
public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
