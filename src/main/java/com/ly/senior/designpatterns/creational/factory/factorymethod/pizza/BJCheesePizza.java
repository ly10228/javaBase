package com.ly.senior.designpatterns.creational.factory.factorymethod.pizza;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 14:52
 *  * @last modify by [luoyong 2019-09-09 14:52]
 * @Description: BJCheesePizza
 **/
public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的奶酪pizza");
        System.out.println(" 北京的奶酪pizza 准备原材料");
    }
}
