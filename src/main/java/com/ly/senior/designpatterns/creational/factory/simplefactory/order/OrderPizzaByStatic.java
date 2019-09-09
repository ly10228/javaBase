package com.ly.senior.designpatterns.creational.factory.simplefactory.order;

import com.ly.senior.designpatterns.creational.factory.simplefactory.SimpleFactory;
import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author luoyong
 * @Description: OrderPizza
 * @create 2019-09-08 23:52
 * @last modify by [LuoYong 2019-09-08 23:52]
 **/
public class OrderPizzaByStatic {

    Pizza pizza = null;

    public OrderPizzaByStatic() {
        //用户输入的
        String orderType = "";

        do {
            orderType = getType();
            pizza = SimpleFactory.createStaticPizza(orderType);
            //输出pizza
            if (pizza != null) {
                //订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        } while (true);
    }

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
