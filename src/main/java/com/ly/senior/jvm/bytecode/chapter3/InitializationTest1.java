package com.ly.senior.jvm.bytecode.chapter3;

/**
 * @author luoyong
 *  * @create 2021-05-16 12:28 下午
 *  * @last modify by [luoyong 2021-05-16 12:28 下午]
 * @Description: 那些场景下面编译器不会生成clint<></>方法
 **/
public class InitializationTest1 {
    //场景1：对应非静态的字段，不管是否进行了显式赋值，都不会生成<clinit>()方法
    public int num = 1;
    //场景2：静态的字段，没有显式的赋值，不会生成<clinit>()方法
    public static int num1;
    //场景3：比如对于声明为static final的基本数据类型的字段，不管是否进行了显式赋值，都不会生成<clinit>()方法
    public static final int num2 = 1;
}
