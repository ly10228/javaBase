package com.ly.base.opp.classstructure.keyword.statickey.exer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: static关键字的应用
 * @create 2019-11-12 23:17
 * @last modify by [LuoYong 2019-11-12 23:17]
 **/
public class CircleTest {

    /**
     * @param
     * @return void
     * @Description: static 关键字的使用
     * @author luoyong
     * @create 23:19 2019/11/12
     * @last modify by [LuoYong 23:19 2019/11/12 ]
     */
    @Test
    public void test() {
        Circle c1 = new Circle();

        Circle c2 = new Circle();

        Circle c3 = new Circle(3.4);
        System.out.println("c1的id：" + c1.getId());
        System.out.println("c2的id：" + c2.getId());
        System.out.println("c3的id：" + c3.getId());

        System.out.println("创建的圆的个数为：" + Circle.getTotal());

    }
}


class Circle {

    private double radius;
    /**
     * 自动赋值
     */
    private static int id;

    /**
     * 记录创建的圆的个数
     */
    private static int total;

    /**
     * static声明的属性被所有对象所共享
     */
    private static int init = 1001;


    public Circle() {
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
//		id = init++;
//		total++;
        this.radius = radius;

    }

    public double findArea() {
        return 3.14 * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

}