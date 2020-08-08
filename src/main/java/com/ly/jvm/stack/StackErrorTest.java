package com.ly.jvm.stack;

/**
 * @author luoyong
 *  * @create 2020-08-08 3:56 下午
 *  * @last modify by [luoyong 2020-08-08 3:56 下午]
 * @Description: StackErrorTest 演示栈中的异常
 * 默认情况下：count : 11420
 * 设置栈的大小： -Xss256k : count : 2465
 **/
public class StackErrorTest {
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
