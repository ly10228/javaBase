package com.ly.senior.jvm.classload.classuse;

import org.junit.Test;

import java.util.Random;

/**
 * @author luoyong
 *  * @create 2021-05-05 12:43 下午
 *  * @last modify by [luoyong 2021-05-05 12:43 下午]
 * @Description: 3 当使用类、接口的静态字段时(final修饰特殊考虑)，比如，使用getstatic或者putstatic指令。
 **/
public class ActiveUse2 {
    @Test
    public void test1() {
//        System.out.println(User.num);
//        System.out.println(User.num1);
        System.out.println(User.num2);
    }

    @Test
    public void test2() {
//        System.out.println(CompareA.NUM1);
        System.out.println(CompareA1.NUM2);
    }
}

class User {
    static {
        System.out.println("User类的初始化过程");
    }

    public static int num = 1;
    public static final int num1 = 1;
    public static final int num2 = new Random().nextInt(10);

}

interface CompareA1 {
    public static final Thread t = new Thread() {
        {
            System.out.println("CompareA的初始化");
        }
    };

    //链接阶段赋值
    public static final int NUM1 = 1;
    //初始化阶段赋值
    public static final int NUM2 = new Random().nextInt(10);

}
