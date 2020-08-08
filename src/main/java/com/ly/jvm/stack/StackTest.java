package com.ly.jvm.stack;

/**
 * @author luoyong
 *  * @create 2020-08-08 3:45 下午
 *  * @last modify by [luoyong 2020-08-08 3:45 下午]
 * @Description: StackTest
 **/
public class StackTest {
    public static void main(String[] args) {
        StackTest test = new StackTest();
        test.methodA();
    }

    public void methodA() {
        int i = 10;
        int j = 20;

        methodB();
    }

    public void methodB() {
        int k = 30;
        int m = 40;
    }
}
