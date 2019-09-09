package com.ly.senior.designpatterns.creational.factory.factorymethod.order;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author luoyong
 *  * @create 2019-09-09 14:58
 *  * @last modify by [luoyong 2019-09-09 14:58]
 * @Description: OrderPizza
 **/
public abstract class OrderPizza {
    /**
     * @param orderType pizza类型
     * @return
     * @Description: 让各个子工厂类自己实现
     * @author luoyong
     * @create 15:01 2019-09-09
     * @last modify by [luoyong 15:01 2019-09-09 ]
     */
    abstract Pizza createPizza(String orderType);


    public OrderPizza() {
        Pizza pizza = null;
        String orderType; // 订购披萨的类型
        do {
            orderType = getType();
            //抽象方法，由工厂子类完成
            pizza = createPizza(orderType);
            if (null != pizza) {
                //输出pizza 制作过程
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("没有该种类pizza");
            }
        } while (true);
    }

    /**
     * @return java.lang.String
     * @Description: 写一个方法，可以获取客户希望订购的披萨种类
     * @author luoyong
     * @create 15:04 2019-09-09
     * @last modify by [luoyong 15:04 2019-09-09 ]
     */
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("工厂方法模式：input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
