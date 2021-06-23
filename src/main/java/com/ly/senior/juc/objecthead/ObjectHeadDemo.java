package com.ly.senior.juc.objecthead;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author luoyong
 *  * @create 2021-06-23 1:14 下午
 *  * @last modify by [luoyong 2021-06-23 1:14 下午]
 * @Description: 对象头布局
 **/
public class ObjectHeadDemo {
    public static void main(String[] args) {
        Object object = new Object();

        //引入了JOL，直接使用
        System.out.println(ClassLayout.parseInstance(object).toPrintable());

        //java5之前 只有重量级锁
        new Thread(() -> {
            synchronized (object) {
                System.out.println("----hello juc");
            }
        }, "t1").start();

        System.out.println("----myObjectInfo");
        MyObject myObject = new MyObject();
        System.out.println(myObject.hashCode());
        System.out.println(Integer.toBinaryString(myObject.hashCode()));
        System.out.println(Integer.toHexString(myObject.hashCode()));
        System.out.println(ClassLayout.parseInstance(myObject).toPrintable());
    }


}


class MyObject {
    private int i = 2;
    private boolean flag = true;
    private double d = 2;
}