package com.ly.base.opp.valuetransfer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: ValueTransferTest--值传递
 * 如果变量是基本数据类型，此时赋值的是变量所保存的数据值。
 * 如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值。
 * @create 2019-10-13 10:24
 * @last modify by [LuoYong 2019-10-13 10:24]
 **/
public class ValueTransferTest {

    @Test
    public void test() {
        System.out.println("***********基本数据类型：****************");
        int m = 10;
        int n = m;

        System.out.println("m = " + m + ", n = " + n);

        n = 20;

        System.out.println("m = " + m + ", n = " + n);

        System.out.println("***********引用数据类型：****************");

        Order o1 = new Order();
        o1.orderId = 1001;

        //赋值以后，o1和o2的地址值相同，都指向了堆空间中同一个对象实体。
        Order o2 = o1;

        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);

        o2.orderId = 1002;

        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);
    }
}

class Order {

    int orderId;

}
