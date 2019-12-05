package com.ly.base.opp.wrapper.exer;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-11-10 13:37
 *  * @last modify by [luoyong 2019-11-10 13:37]
 * @Description: InterviewTest  包装类的练习
 **/
public class InterviewTest {
    @Test
    public void test1() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        // 1.0
        //三目运算类型一致的问题 Integer Double
        System.out.println(o1);

    }

    @Test
    public void test2() {
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        // 1
        System.out.println(o2);

    }

    @Test
    public void test3() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        //false
        System.out.println(i == j);

        //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
        //保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在
        //-128~127范围内时，可以直接使用数组中的元素，不用再去new了。目的：提高效率

        Integer m = 1;
        Integer n = 1;
        //true
        System.out.println(m == n);

        //相当于new了一个Integer对象
        Integer x = 128;
        //相当于new了一个Integer对象
        Integer y = 128;
        //false
        System.out.println(x == y);
    }
}
