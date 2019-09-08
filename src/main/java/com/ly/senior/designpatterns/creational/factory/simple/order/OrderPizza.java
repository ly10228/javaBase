package com.ly.senior.designpatterns.creational.factory.simple.order;

import com.ly.senior.designpatterns.creational.factory.simple.pizza.CheesePizza;
import com.ly.senior.designpatterns.creational.factory.simple.pizza.GreekPizza;
import com.ly.senior.designpatterns.creational.factory.simple.pizza.PepperPizza;
import com.ly.senior.designpatterns.creational.factory.simple.pizza.Pizza;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author luoyong
 * @Description: OrderPizza 订购pizza
 * @create 2019-09-08 22:28
 * @last modify by [LuoYong 2019-09-08 22:28]
 **/
@Data
public class OrderPizza {
    public OrderPizza() {
        Pizza pizza = null;
        /**
         *  订购披萨的类型
         */
        String orderType;
        do {
            //获取订购披萨的类型
            orderType = getType();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
                pizza.setName(" 希腊披萨 ");
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName(" 奶酪披萨 ");
            } else if (orderType.equals("pepper")) {
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
            } else {
                break;
            }
            //输出pizza 制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);
    }

    /**
     * @param
     * @return
     * @Description: 获取客户希望订购的披萨种类
     * @author luoyong
     * @create 22:30 2019/9/8
     * @last modify by [LuoYong 22:30 2019/9/8 ]
     */
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
