package com.ly.senior.designpatterns.structured.decorator.decorator;

import com.ly.senior.designpatterns.structured.decorator.Drink;

/**
 * @author luoyong
 * @Description: Milk
 * @create 2019-09-14 20:37
 * @last modify by [LuoYong 2019-09-14 20:37]
 **/
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDesc("牛奶");
        setPrice(2.0f);
    }
}
