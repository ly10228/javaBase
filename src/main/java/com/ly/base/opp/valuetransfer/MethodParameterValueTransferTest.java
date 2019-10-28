package com.ly.base.opp.valuetransfer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 方法形参的值传递机制--基本数据类型
 * 1.形参：方法定义时，声明的小括号内的参数
 * 实参：方法调用时，实际传递给形参的数据
 * <p>
 * 2.值传递机制：
 * 如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值。
 * 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值。
 * @create 2019-10-13 10:30
 * @last modify by [LuoYong 2019-10-13 10:30]
 **/
public class MethodParameterValueTransferTest {

    @Test
    public void test() {
        int m = 10;
        int n = 20;

        System.out.println("m = " + m + ", n = " + n);
        //交换两个变量的值的操作
//		int temp = m ;
//		m = n;
//		n = temp;

        MethodParameterValueTransferTest test = new MethodParameterValueTransferTest();
        //交换只在方法内生效--参数是基本数据类型
        test.swap(m, n);

        System.out.println("m = " + m + ", n = " + n);

    }

    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
        System.out.println("m = " + m + ", n = " + n);
    }
}
