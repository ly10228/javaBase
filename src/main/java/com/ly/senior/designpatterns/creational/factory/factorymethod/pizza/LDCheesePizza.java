package com.ly.senior.designpatterns.creational.factory.factorymethod.pizza;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 14:56
 *  * @last modify by [luoyong 2019-09-09 14:56]
 * @Description: LDCheesePizza
 **/
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的奶酪pizza");
        System.out.println(" 伦敦的奶酪pizza 准备原材料");
    }
}
