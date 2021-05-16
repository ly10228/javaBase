package com.ly.senior.jvm.bytecode.chapter3;

/**
 * @author luoyong
 *  * @create 2021-05-16 12:19 下午
 *  * @last modify by [luoyong 2021-05-16 12:19 下午]
 * @Description: 过程三：初始化阶段
 **/
public class InitializationTest {
    public static int id = 1;
    public static int number;

    static {
        number = 2;
        System.out.println("father static{}");
    }
}
