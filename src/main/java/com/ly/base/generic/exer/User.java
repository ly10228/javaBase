package com.ly.base.generic.exer;

import lombok.Data;

/**
 * @author luoyong
 * @Description: User
 * @create 2019-12-23 17:52
 * @last modify by [LuoYong 2019-12-23 17:52]
 **/
@Data
public class User {

    private int id;

    private int age;

    private String name;

    public User(int id, int age, String name) {

        this.id = id;
        this.age = age;
        this.name = name;
    }

    public User() {

    }
}
