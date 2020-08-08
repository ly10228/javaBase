package com.ly.base.jvm.statck;

/**
 * @author luoyong
 *  * @create 2020-08-08 4:32 下午
 *  * @last modify by [luoyong 2020-08-08 4:32 下午]
 * @Description: 栈异常
 * 默认情况下：count : 9971
 * 设置栈的大小： -Xss256k : count : 1873
 **/
public class StackErrorTest {
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
