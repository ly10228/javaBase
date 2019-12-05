package com.ly.base.opp.object;

import org.junit.Test;

import java.util.Date;

/**
 * @author luoyong
 *  * @create 2019-11-10 11:39
 *  * @last modify by [luoyong 2019-11-10 11:39]
 * @Description: EqualsTest
 * 一、回顾 == 的使用：
 * == ：运算符
 * 1. 可以使用在基本数据类型变量和引用数据类型变量中
 * 2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 * 如果比较的是引用数据类型变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 补充： == 符号使用时，必须保证符号左右两边的变量类型一致。
 * <p>
 * 二、equals()方法的使用：
 * 1. 是一个方法，而非运算符
 * 2. 只能适用于引用数据类型
 * 3. Object类中equals()的定义：
 * public boolean equals(Object obj) {
 * return (this == obj);
 * }
 * 说明：Object类中定义的equals()和==的作用是相同的：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * <p>
 * 4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是
 * 两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同。
 * <p>
 * 5. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们
 * 就需要对Object类中的equals()进行重写.
 * 重写的原则：比较两个对象的实体内容是否相同.
 **/
public class EqualsTest {
    @Test
    private void test() {
        //基本数据类型
        int i = 10;
        int j = 10;
        double d = 10.0;
        //true
        System.out.println(i == j);
        //true
        System.out.println(i == d);

        boolean b = true;
//		System.out.println(i == b);

        char c = 10;
        //true
        System.out.println(i == c);

        char c1 = 'A';
        char c2 = 65;
        //true
        System.out.println(c1 == c2);

        //引用类型：
        Customer cus1 = new Customer("Tom", 21);
        Customer cus2 = new Customer("Tom", 21);
        //false
        System.out.println(cus1 == cus2);

        String str1 = new String("atguigu");
        String str2 = new String("atguigu");
        System.out.println(str1 == str2);//false
        System.out.println("****************************");
        //false--->true
        System.out.println(cus1.equals(cus2));
        //true
        System.out.println(str1.equals(str2));

        Date date1 = new Date(32432525324L);
        Date date2 = new Date(32432525324L);
        //true
        System.out.println(date1.equals(date2));
    }
}
