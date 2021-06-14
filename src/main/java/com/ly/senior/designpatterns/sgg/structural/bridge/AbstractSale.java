package com.ly.senior.designpatterns.sgg.structural.bridge;

/**
 * @author luoyong
 *  * @create 2021-06-14 5:38 下午
 *  * @last modify by [luoyong 2021-06-14 5:38 下午]
 * @Description: 销售渠道抽象
 **/
public abstract class AbstractSale {

    private String type;

    private Integer price;

    public AbstractSale(String type, Integer price) {
        this.type = type;
        this.price = price;
    }

    String getSaleInfo() {
        return "渠道：" + type + "==>" + "价格：" + price;
    }

    void howToSale() {
        //都不一样
    }
}
