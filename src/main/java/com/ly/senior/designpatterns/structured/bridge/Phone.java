package com.ly.senior.designpatterns.structured.bridge;

/**
 * @author luoyong
 * @Description: Phone 手机
 * @create 2019-09-14 16:34
 * @last modify by [LuoYong 2019-09-14 16:34]
 **/
public abstract class Phone {
    //聚合品牌
    private Brand brand;

    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.call();
    }
}
