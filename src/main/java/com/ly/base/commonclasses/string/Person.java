package com.ly.base.commonclasses.string;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2019-11-30 23:02
 *  * @last modify by [luoyong 2019-11-30 23:02]
 * @Description: Person
 **/
@Data
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
