package com.ly.senior.datastructure.recursion;

/**
 * @author luoyong
 *  * @create 2020-04-27 10:34 下午
 *  * @last modify by [luoyong 2020-04-27 10:34 下午]
 * @Description: RecursionTest
 **/
public class RecursionTest {


    public static void main(String[] args) {
        //通过打印问题，回顾递归调用机制
        test(4);
        System.out.println("*************");
        test1(4);

        int res = factorial(3);
        System.out.println("res=" + res);
    }

    /**
     * @param n
     * @return void
     * @Description: 打印问题
     * @author luoyong
     * @create 10:35 下午 2020/4/27
     * @last modify by [LuoYong 10:35 下午 2020/4/27 ]
     */
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    public static void test1(int n) {
        if (n > 2) {
            test1(n - 1);
        } else {
            System.out.println("n=" + n);
        }

    }


    /**
     * @param n
     * @return int
     * @Description: 阶乘问题
     * @author luoyong
     * @create 10:50 下午 2020/4/27
     * @last modify by [LuoYong 10:50 下午 2020/4/27 ]
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            // 1 * 2 * 3
            return factorial(n - 1) * n;
        }
    }
}
