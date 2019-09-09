package com.ly.senior.designpatterns.creational.factory.simplefactory;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.CheesePizza;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.GreekPizza;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.PepperPizza;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 * @Description: SimpleFactory 简单工厂模式也成静态工厂模式
 * @create 2019-09-08 23:43
 * @last modify by [LuoYong 2019-09-08 23:43]
 **/
public class SimpleFactory {
    /**
     * @param orderType Pizza类型
     * @return
     * @Description: 根据Pizza类型创建Pizza
     * @author luoyong
     * @create 23:44 2019/9/8
     * @last modify by [LuoYong 23:44 2019/9/8 ]
     */
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;
    }

    /**
     * @param orderType
     * @return
     * @Description: 简单工厂模式 也叫 静态工厂模式
     * @author luoyong
     * @create 0:05 2019/9/9
     * @last modify by [LuoYong 0:05 2019/9/9 ]
     */
    public static Pizza createStaticPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;
    }
}
