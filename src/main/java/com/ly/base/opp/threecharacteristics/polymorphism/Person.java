package com.ly.base.opp.threecharacteristics.polymorphism;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Person
 * @create 2019-11-04 21:44
 * @last modify by [LuoYong 2019-11-04 21:44]
 **/
@Data
public class Person {
    String name;
    int age;

    int id = 1001;

    public void eat() {
        System.out.println("人：吃饭");
    }

    public void walk() {
        System.out.println("人：走路");
    }
}
