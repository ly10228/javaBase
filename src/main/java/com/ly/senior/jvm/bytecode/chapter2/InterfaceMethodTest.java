package com.ly.senior.jvm.bytecode.chapter2;

/**
 * @author luoyong
 *  * @create 2021-05-15 9:23 下午
 *  * @last modify by [luoyong 2021-05-15 9:23 下午]
 * @Description: 补充：方法调用指令的补充说明
 **/
public class InterfaceMethodTest {
    public static void main(String[] args) {
        AA aa = new BB();

        aa.method2();

        AA.method1();
    }
}


interface AA {
    public static void method1() {

    }

    public default void method2() {

    }
}

class BB implements AA {

}