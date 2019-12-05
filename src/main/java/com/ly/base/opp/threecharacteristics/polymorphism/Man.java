package com.ly.base.opp.threecharacteristics.polymorphism;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Man
 * @create 2019-11-04 21:45
 * @last modify by [LuoYong 2019-11-04 21:45]
 **/
@Data
public class Man extends Person {
    boolean isSmoking;

    int id = 1002;

    public void earnMoney() {
        System.out.println("男人负责挣钱养家");
    }

//    public void eat() {
//        System.out.println("男人多吃肉，长肌肉");
//    }

    public void walk() {
        System.out.println("男人霸气的走路");
    }
}
