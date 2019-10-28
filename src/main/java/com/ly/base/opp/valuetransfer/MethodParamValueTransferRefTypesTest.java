package com.ly.base.opp.valuetransfer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 方法形参的值传递机制--引用数据类型
 * 1.形参：方法定义时，声明的小括号内的参数
 * 实参：方法调用时，实际传递给形参的数据
 * <p>
 * 2.值传递机制：
 * 如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值。
 * 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值。
 * @create 2019-10-13 10:30
 * @last modify by [LuoYong 2019-10-13 10:30]
 **/
public class MethodParamValueTransferRefTypesTest {

    @Test
    public void test() {
        Data data = new Data();

        data.m = 10;
        data.n = 20;

        System.out.println("m = " + data.m + ", n = " + data.n);

        //交换m和n的值
//		int temp = data.m;
//		data.m = data.n;
//		data.n = temp;

        MethodParamValueTransferRefTypesTest test = new MethodParamValueTransferRefTypesTest();
        test.swap(data);


        System.out.println("m = " + data.m + ", n = " + data.n);


    }

    public void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data {

    int m;
    int n;

}