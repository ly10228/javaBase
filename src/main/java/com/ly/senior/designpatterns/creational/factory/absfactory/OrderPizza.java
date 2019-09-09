package com.ly.senior.designpatterns.creational.factory.absfactory;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:20
 *  * @last modify by [luoyong 2019-09-09 15:20]
 * @Description: OrderPizza
 **/
public class OrderPizza {
    private CreatePizza createPizza;

    public OrderPizza(CreatePizza createPizza) {
        this.createPizza(createPizza);
    }

    private void createPizza(CreatePizza createPizza) {
        Pizza pizza = null;
        // 用户输入
        String orderType = "";
        this.createPizza = createPizza;
        do {
            orderType = getType();
            // factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = createPizza.createPizza(orderType);
            if (pizza != null) { // 订购ok
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
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
