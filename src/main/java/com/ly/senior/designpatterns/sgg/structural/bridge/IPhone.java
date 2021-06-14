package com.ly.senior.designpatterns.sgg.structural.bridge;

/**
 * @author luoyong
 *  * @create 2021-06-14 5:40 下午
 *  * @last modify by [luoyong 2021-06-14 5:40 下午]
 * @Description: IPhone
 **/
public class IPhone extends AbstractPhone {
    @Override
    String getPhone() {
        return "IPhone：" + sale.getSaleInfo();
    }
}
