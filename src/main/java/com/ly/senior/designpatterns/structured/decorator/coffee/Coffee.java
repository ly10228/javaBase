package com.ly.senior.designpatterns.structured.decorator.coffee;

import com.ly.senior.designpatterns.structured.decorator.Drink;

/**
 * @author luoyong
 * @Description: Coffee
 * @create 2019-09-14 17:27
 * @last modify by [LuoYong 2019-09-14 17:27]
 **/
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
