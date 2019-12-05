package com.ly.base.opp.threecharacteristics.abstraction;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 抽象类的匿名子类
 * @create 2019-11-16 22:16
 * @last modify by [LuoYong 2019-11-16 22:16]
 **/
public class AnonymousSubclassOfAbstractClass {

    @Test
    public void test() {

        //匿名对象
        method(new Student());

        //非匿名的类非匿名的对象
        Worker worker = new Worker();
        method1(worker);

        /**
         * 创建了一个匿名子类的对象：p
         */
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("匿名子对象--吃东西");
            }

            @Override
            public void breath() {
                System.out.println("匿名子对象--呼吸");
            }
        };
        method1(p);

        //创建匿名子类匿名对象
        method1(new Person() {
            @Override
            public void eat() {
                System.out.println("匿名子类匿名对象--好好吃饭");
            }

            @Override
            public void breath() {
                System.out.println("匿名子类匿名对象--大口呼吸");
            }
        });
    }

    public static void method1(Person p) {
        p.eat();
        p.breath();
    }

    public static void method(Student s) {

    }
}


class Worker extends Person {

    @Override
    public void eat() {
    }

    @Override
    public void breath() {
    }

}