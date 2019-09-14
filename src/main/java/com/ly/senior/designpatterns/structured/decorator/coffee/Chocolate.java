package com.ly.senior.designpatterns.structured.decorator.coffee;

import com.ly.senior.designpatterns.structured.decorator.Drink;
import com.ly.senior.designpatterns.structured.decorator.decorator.Decorator;

/**
 * @author luoyong
 * @Description: Chocolate
 * @create 2019-09-14 20:35
 * @last modify by [LuoYong 2019-09-14 20:35]
 **/
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDesc(" 巧克力 ");
        // 调味品 的价格
        setPrice(3.0f);
    }
}
