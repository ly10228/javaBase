package com.ly.senior.jvm.classload.classuse;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2021-05-05 12:53 下午
 *  * @last modify by [luoyong 2021-05-05 12:53 下午]
 * @Description: 1. 当访问一个静态字段时，只有真正声明这个字段的类才会被初始化。
 * > 当通过子类引用父类的静态变量，不会导致子类初始化
 * 2. 通过数组定义类引用，不会触发此类的初始化
 **/
public class PassiveUse1 {
    @Test
    public void test1() {
        System.out.println(Child.num);
    }

    @Test
    public void test2() {
        Parent[] parents = new Parent[10];
        System.out.println(parents.getClass());
        //java.lang.Object
        System.out.println(parents.getClass().getSuperclass());


        parents[0] = new Parent();
        parents[1] = new Parent();
    }
}

class Parent {
    static {
        System.out.println("Parent的初始化过程");
    }

    public static int num = 1;
}

class Child extends Parent {
    static {
        System.out.println("Child的初始化过程");
    }
}
