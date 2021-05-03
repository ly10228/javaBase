package com.ly.senior.jvm.bytecode;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2021-05-03 10:05 下午
 *  * @last modify by [luoyong 2021-05-03 10:05 下午]
 * @Description: InterviewTest
 **/
public class InterviewTest {
    @Test
    public void test1() {
        Integer x = 128;
        int y = 128;
        //true
        System.out.println(x == y);
    }

    @Test
    public void test2() {
        Integer x = 5;
        int y = 5;
        //true
        System.out.println(x == y);
    }
}
