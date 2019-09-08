package com.ly.senior.designpatterns.creational.factory.simple.pizza;

/**
 * @author luoyong
 * @Description: CheesePizza
 * @create 2019-09-08 22:25
 * @last modify by [LuoYong 2019-09-08 22:25]
 **/
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 给制作奶酪披萨 准备原材料 ");
    }
}
