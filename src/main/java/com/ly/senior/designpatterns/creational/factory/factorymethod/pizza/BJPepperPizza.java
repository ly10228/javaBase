package com.ly.senior.designpatterns.creational.factory.factorymethod.pizza;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 14:55
 *  * @last modify by [luoyong 2019-09-09 14:55]
 * @Description: BJPepperPizza
 **/
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的胡椒pizza");
        System.out.println(" 北京的胡椒pizza 准备原材料");
    }
}
