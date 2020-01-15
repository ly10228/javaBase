package com.ly.utils;

/**
 * @author luoyong
 *  * @create 2020-01-15 16:35
 *  * @last modify by [luoyong 2020-01-15 16:35]
 * @Description: MathUtils
 **/
public class MathUtils {
    /**
     * @return void
     * @Description: 打印100以内的偶数
     * @author luoyong
     * @create 16:36 2020-01-15
     * @last modify by [LuoYong 16:36 2020-01-15 ]
     */
    public static void printEven() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                //输出偶数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    /**
     * @return void
     * @Description: 打印100以内的奇数
     * @author luoyong
     * @create 16:40 2020-01-15
     * @last modify by [LuoYong 16:40 2020-01-15 ]
     */
    public static void printOddNumber() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                //输出奇数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }


}
