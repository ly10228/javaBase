package com.ly.base.opp.classstructure.keyword.interfacekey.exer2.abs;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Circle 定义一个Circle类，声明radius属性，提供getter和setter方法
 * @create 2019-11-20 22:44
 * @last modify by [LuoYong 2019-11-20 22:44]
 **/
@Data
public class Circle extends AbsCompareObject {
    private Double radius;

    public Circle() {
        super();
    }

    public Circle(Double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof Circle) {
            Circle compareCircle = (Circle) o;
            //类型相同
            return this.getRadius().compareTo(compareCircle.getRadius());
        } else {
            throw new RuntimeException("输入类型与当前对象不匹配");
        }
    }
}
