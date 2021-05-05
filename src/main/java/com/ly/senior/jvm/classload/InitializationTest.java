package com.ly.senior.jvm.classload;

/**
 * @author luoyong
 *  * @create 2021-05-05 11:26 上午
 *  * @last modify by [luoyong 2021-05-05 11:26 上午]
 * @Description: InitializationTest
 **/
public class InitializationTest {
    public static int id = 1;
    public static int number;

    static {
        number = 2;
        System.out.println("father static{}");
    }
}
