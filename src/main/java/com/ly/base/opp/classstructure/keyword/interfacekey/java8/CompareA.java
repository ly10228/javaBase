package com.ly.base.opp.classstructure.keyword.interfacekey.java8;

/**
 * @author luoyong
 * @Description: CompareA
 * JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 * @create 2019-11-23 10:53
 * @last modify by [LuoYong 2019-11-23 10:53]
 **/
public interface CompareA {


    /**
     * @param
     * @return void
     * @Description: 静态方法
     * @author luoyong
     * @create 15:23 2019/11/24
     * @last modify by [LuoYong 15:23 2019/11/24 ]
     */
    static void method1() {
        System.out.println("CompareA:北京");
    }


    /**
     * @param
     * @return void
     * @Description: 默认方法
     * @author luoyong
     * @create 15:24 2019/11/24
     * @last modify by [LuoYong 15:24 2019/11/24 ]
     */
    public default void method2() {
        System.out.println("CompareA：上海");
    }

    default void method3() {
        System.out.println("CompareA：上海");
    }
}
