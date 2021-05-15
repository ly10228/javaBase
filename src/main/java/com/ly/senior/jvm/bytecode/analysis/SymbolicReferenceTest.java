package com.ly.senior.jvm.bytecode.analysis;

/**
 * @author luoyong
 *  * @create 2021-05-15 10:43 上午
 *  * @last modify by [luoyong 2021-05-15 10:43 上午]
 * @Description: 符号引用测试
 **/
public class SymbolicReferenceTest {
    public static void main(String[] args) {
        Object[] arr = new Object[10];
        System.out.println(arr);//[Ljava.lang.Object;@78308db1

        String[] arr1 = new String[10];
        System.out.println(arr1);//[Ljava.lang.String;@27c170f0

        long[][] arr2 = new long[10][];
        System.out.println(arr2);//[[J@5451c3a8
    }
}
