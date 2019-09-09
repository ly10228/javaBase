package com.ly.senior.designpatterns.creational.factory.absfactory;

import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.BJCheesePizza;
import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.BJPepperPizza;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:18
 *  * @last modify by [luoyong 2019-09-09 15:18]
 * @Description: BJCreatePizzaImpl
 **/
public class BJCreatePizzaImpl implements CreatePizza {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
