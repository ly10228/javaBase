package com.ly.base.opp.encapsulation;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: OrderTest
 * @create 2019-10-13 16:40
 * @last modify by [LuoYong 2019-10-13 16:40]
 **/
public class OrderTest {

    @Test
    public void test() {
        Order order = new Order();

        order.orderDefault = 1;
        order.orderPublic = 2;
        //出了Order类之后，私有的结构就不可以调用了
//		order.orderPrivate = 3;//The field Order.orderPrivate is not visible

        order.methodDefault();
        order.methodPublic();
        //出了Order类之后，私有的结构就不可以调用了
//		order.methodPrivate();//The method methodPrivate() from the type Order is not visible
    }
}
