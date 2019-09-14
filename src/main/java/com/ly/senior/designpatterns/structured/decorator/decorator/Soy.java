package com.ly.senior.designpatterns.structured.decorator.decorator;

import com.ly.senior.designpatterns.structured.decorator.Drink;

/**
 * @author luoyong
 * @Description: Soy
 * @create 2019-09-14 20:38
 * @last modify by [LuoYong 2019-09-14 20:38]
 **/
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDesc("豆浆");
        setPrice(1.5f);
    }
}
