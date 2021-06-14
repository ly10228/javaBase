package com.ly.senior.designpatterns.sgg.creatation;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2021-06-14 2:17 下午
 *  * @last modify by [luoyong 2021-06-14 2:17 下午]
 * @Description: 单例模式
 **/
@Data
public class Person {
    private String name;
    private String age;

    //懒汉、饿汉
    private volatile static Person instance;

    //构造器私有，外部不能实例化
    private Person() {
        System.out.println("创建了Person");
    }

    /**
     * @return
     * @Description: 提供给外部的方法
     * 1、public static synchronized Person guiguBoss() 锁太大
     * 2、双重检查锁+内存可见性（设计模式）
     * @author luoyong
     * @create 2:18 下午 2021/6/14
     * @last modify by [LuoYong 2:18 下午 2021/6/14 ]
     */
    public static Person guiguBoss() {
        //如果没有再去创建
        if (instance == null) {
            synchronized (Person.class) {
                if (instance == null) {
                    Person person = new Person();
                    //多线程问题
                    instance = person;
                }
            }
        }
        return instance;
    }

}
