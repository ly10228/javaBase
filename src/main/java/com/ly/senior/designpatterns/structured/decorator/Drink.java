package com.ly.senior.designpatterns.structured.decorator;

/**
 * @author luoyong
 * @Description: Drink
 * @create 2019-09-14 17:24
 * @last modify by [LuoYong 2019-09-14 17:24]
 **/

public abstract class Drink {
    /**
     * 描述
     */
    public String desc;

    /**
     * 价钱
     */
    private float price = 0.0f;


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 计算费用的方法 子类来实现
     *
     * @return
     */
    public abstract float cost();
}
