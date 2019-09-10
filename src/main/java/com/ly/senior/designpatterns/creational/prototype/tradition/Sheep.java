package com.ly.senior.designpatterns.creational.prototype.tradition;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2019-09-10 10:57
 *  * @last modify by [luoyong 2019-09-10 10:57]
 * @Description: Sheep
 **/
@Data
public class Sheep {
    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 颜色
     */
    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
