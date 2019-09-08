package com.ly.senior.designpatterns.creational.factory.simple.pizza;

/**
 * @author luoyong
 * @Description: GreekPizza
 * @create 2019-09-08 22:26
 * @last modify by [LuoYong 2019-09-08 22:26]
 **/
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 给希腊披萨 准备原材料 ");
    }
}
