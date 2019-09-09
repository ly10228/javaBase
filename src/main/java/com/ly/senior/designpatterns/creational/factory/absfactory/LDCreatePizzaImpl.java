package com.ly.senior.designpatterns.creational.factory.absfactory;

import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.LDCheesePizza;
import com.ly.senior.designpatterns.creational.factory.factorymethod.pizza.LDPepperPizza;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:19
 *  * @last modify by [luoyong 2019-09-09 15:19]
 * @Description: LDCreatePizzaImpl
 **/
public class LDCreatePizzaImpl implements CreatePizza {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
