package com.ly.senior.jvm.bytecode.analysis;

/**
 * @author luoyong
 *  * @create 2021-05-09 2:25 下午
 *  * @last modify by [luoyong 2021-05-09 2:25 下午]
 * @Description: 字节码分析
 **/
public class StringTest {
    public static void main(String[] args) {
        String str = new String("hello") + new String("World");
        String str1 = "helloWorld";
        System.out.println(str == str1);
        String str2 = new String("helloWorld");
        System.out.println(str == str2);
    }

    public void method1() {

    }

    public void method1(int num) {

    }

//    public int method1(int num){
//        return 1;
//    }
}
