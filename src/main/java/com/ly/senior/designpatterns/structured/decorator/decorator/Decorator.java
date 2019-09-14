package com.ly.senior.designpatterns.structured.decorator.decorator;

import com.ly.senior.designpatterns.structured.decorator.Drink;

/**
 * @author luoyong
 * @Description: 装饰者
 * @create 2019-09-14 17:32
 * @last modify by [LuoYong 2019-09-14 17:32]
 **/
public class Decorator extends Drink {

    /**
     * 聚合饮料
     */
    private Drink obj;

    public Decorator(Drink drink) {
        this.obj = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDesc() {
        // drink.getDesc() 输出被装饰者的信息
        return desc + " " + getPrice() + " && " + obj.getDesc();
    }
}
