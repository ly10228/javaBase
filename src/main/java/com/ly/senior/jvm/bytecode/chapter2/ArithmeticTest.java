package com.ly.senior.jvm.bytecode.chapter2;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2021-05-15 5:22 下午
 *  * @last modify by [luoyong 2021-05-15 5:22 下午]
 * @Description: 算术指令
 **/
public class ArithmeticTest {
    @Test
    public void method1() {
        int i = 10;
        double j = i / 0.0;
        //无穷大
        System.out.println(j);


        double d1 = 0.0;
        double d2 = d1 / 0.0;
        //NaN: not a number
        System.out.println(d2);
    }

    public void method2() {
        float i = 10;
        float j = -i;
        i = -j;
    }

    public void method3(int j) {
        int i = 100;
//        i = i + 10;
        i += 10;
    }

    public int method4() {
        int a = 80;
        int b = 7;
        int c = 10;
        return (a + b) * c;
    }

    public int method5(int i, int j) {
        return ((i + j - 1) & ~(j - 1));
    }

    //关于(前)++和(后)++
    public void method6() {
        int i = 10;
        i++;
//        ++i;

//        for(int j = 0;j < 10;j++){}
    }

    public void method7() {
        int i = 10;
        int a = i++;

        int j = 20;
        int b = ++j;
    }

    //思考
    public void method8() {
        int i = 10;
        i = i++;
        System.out.println(i);//10
    }
}
