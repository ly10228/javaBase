package com.ly.base.opp.classstructure.keyword.interfacekey.exer2;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Circle 定义一个Circle类，声明radius属性，提供getter和setter方法
 * @create 2019-11-20 22:44
 * @last modify by [LuoYong 2019-11-20 22:44]
 **/
@Data
public class Circle {
    private Double radius;

    public Circle() {
        super();
    }

    public Circle(Double radius) {
        super();
        this.radius = radius;
    }

}
