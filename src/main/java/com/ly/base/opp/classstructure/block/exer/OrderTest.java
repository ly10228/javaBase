package com.ly.base.opp.classstructure.block.exer;

import lombok.Data;
import org.junit.Test;

/**
 * @author luoyong
 * @Description: 对属性可以赋值的位置
 * ①默认初始化
 * ②显式初始化/⑤在代码块中赋值
 * ③构造器中初始化
 * ④有了对象以后，可以通过"对象.属性"或"对象.方法"的方式，进行赋值
 * @create 2019-11-14 22:24
 * @last modify by [LuoYong 2019-11-14 22:24]
 **/
public class OrderTest {

    /**
     * @param
     * @return void
     * @Description: 对象赋值 执行的先后顺序
     * 执行的先后顺序：① - ② / ⑤ - ③ - ④
     * @author luoyong
     * @create 22:25 2019/11/14
     * @last modify by [LuoYong 22:25 2019/11/14 ]
     */
    @Test
    public void test() {
        Order order = new Order();
        order.setOrderId(4);
        System.out.println(order.getOrderId());
    }
}


@Data
class Order {
    private int orderId = 2;

    {
        orderId = 5;
        System.out.println(orderId);
    }

    public Order() {
        this.orderId = 3;
        System.out.println(this.orderId);
    }
}