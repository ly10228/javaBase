package com.ly.senior.designpatterns.jdksource;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: FlyWeight
 * @create 2019-09-15 17:11
 * @last modify by [LuoYong 2019-09-15 17:11]
 **/
public class FlyWeight {

    @Test
    public void test() {
        /**
         * 如果 Integer.valueOf(x) x 在  -128 --- 127 直接，就是使用享元模式返回,如果不在
         * 范围类，则仍然 new
         * 1. 在valueOf 方法中，先判断值是否在 IntegerCache 中，如果不在，就创建新的Integer(new), 否则，就直接从 缓存池返回
         * 2. valueOf 方法，就使用到享元模式
         * 3. 如果使用valueOf 方法得到一个Integer 实例，范围在 -128 - 127 ，执行速度比 new 快
         */

        // 得到 x实例，类型 Integer
        Integer x = Integer.valueOf(127);
        // 得到 y 实例，类型 Integer
        Integer y = new Integer(127);
        Integer z = Integer.valueOf(127);
        Integer w = new Integer(127);

        // 大小，true
        System.out.println(x.equals(y));
        //  false
        System.out.println(x == y);
        // true
        System.out.println(x == z);
        // false
        System.out.println(w == x);
        // false
        System.out.println(w == y);


        Integer x1 = Integer.valueOf(200);
        Integer x2 = Integer.valueOf(200);
        // false
        System.out.println("x1==x2" + (x1 == x2));


    }
}
