package com.ly.base.opp.threecharacteristics.polymorphism;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Woman
 * @create 2019-11-04 21:46
 * @last modify by [LuoYong 2019-11-04 21:46]
 **/
@Data
public class Woman extends Person {
    boolean isBeauty;

    public void goShopping() {
        System.out.println("女人喜欢购物");
    }

    public void eat() {
        System.out.println("女人少吃，为了减肥");
    }

    public void walk() {
        System.out.println("女人窈窕的走路");
    }
}
