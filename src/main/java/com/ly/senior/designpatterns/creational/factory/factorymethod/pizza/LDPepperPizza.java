package com.ly.senior.designpatterns.creational.factory.factorymethod.pizza;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 14:57
 *  * @last modify by [luoyong 2019-09-09 14:57]
 * @Description: LDPepperPizza
 **/
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的胡椒pizza");
        System.out.println(" 伦敦的胡椒pizza 准备原材料");
    }
}
