package com.ly.base.opp.object;

import org.junit.Test;

import java.util.Date;

/**
 * @author luoyong
 *  * @create 2019-11-10 11:34
 *  * @last modify by [luoyong 2019-11-10 11:34]
 * @Description: ToStringTest
 * Object类中toString()的使用：
 * <p>
 * 1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 * <p>
 * 2. Object类中toString()的定义：
 * public String toString() {
 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
 * }
 * <p>
 * 3. 像String、Date、File、包装类等都重写了Object类中的toString()方法。
 * 使得在调用对象的toString()时，返回"实体内容"信息
 * <p>
 * 4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
 **/
public class ToStringTest {

    @Test
    public void test() {
        Customer cus1 = new Customer("Tom", 21);
        System.out.println(cus1.toString());
        System.out.println(cus1);

        String str = new String("MM");
        System.out.println(str);//MM

        Date date = new Date(4534534534543L);
        System.out.println(date.toString());
    }
}
