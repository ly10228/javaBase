package com.ly.senior.designpatterns.behaviortype.responsibilitychain;

import lombok.Data;

/**
 * @author luoyong
 * @Description: PurchaseRequest
 * @create 2019-09-22 18:34
 * @last modify by [LuoYong 2019-09-22 18:34]
 **/
@Data
public class PurchaseRequest {
    /**
     * 请求类型
     */
    private int type = 0;
    /**
     * 请求金额
     */
    private float price = 0.0f;

    private int id = 0;

    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }
}
