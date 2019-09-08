package com.ly.senior.designpatterns.creational.factory.tradition.pizza;

/**
 * @author luoyong
 * @Description: PepperPizza
 * @create 2019-09-08 22:26
 * @last modify by [LuoYong 2019-09-08 22:26]
 **/
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 给胡椒披萨准备原材料 ");
    }
}
