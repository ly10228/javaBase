package com.ly.senior.designpatterns.structured.decorator.decorator;

import com.ly.senior.designpatterns.structured.decorator.coffee.Coffee;

/**
 * @author luoyong
 * @Description: DeCaf
 * @create 2019-09-14 20:33
 * @last modify by [LuoYong 2019-09-14 20:33]
 **/
public class DeCaf extends Coffee {
    public DeCaf() {
        setDesc(" 无因咖啡 ");
        setPrice(1.0f);
    }
}
