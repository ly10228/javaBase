package com.ly.senior.jvm.bytecode.analysis;

/**
 * @author luoyong
 *  * @create 2021-05-09 2:22 下午
 *  * @last modify by [luoyong 2021-05-09 2:22 下午]
 * @Description: 字节码分析
 **/
public class IntegerTest {
    public static void main(String[] args) {
        Integer x = 5;
        int y = 5;
        System.out.println(x == y);

        Integer i1 = 10;
        Integer i2 = 10;
        //true
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        //false
        System.out.println(i3 == i4);

    }
}
