package com.ly.senior.designpatterns.creational.prototype.improve;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2019-09-10 11:02
 *  * @last modify by [luoyong 2019-09-10 11:02]
 * @Description: Sheep
 **/
@Data
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;
    private String address = "蒙古羊";
    /**
     * 是对象, 克隆是会如何处理
     */
    public Sheep friend;

    public Sheep(String name, int age, String color) {
        super();
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
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    protected Object clone() {

        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }

}
