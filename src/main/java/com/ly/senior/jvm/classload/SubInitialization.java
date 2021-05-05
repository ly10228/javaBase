package com.ly.senior.jvm.classload;

/**
 * @author luoyong
 *  * @create 2021-05-05 11:25 上午
 *  * @last modify by [luoyong 2021-05-05 11:25 上午]
 * @Description: 子类加载前先加载父类
 **/
public class SubInitialization extends InitializationTest {

    static {
        //number属性必须提前已经加载：一定会先加载父类。
        number = 4;
        System.out.println("son static{}");
    }

    public static void main(String[] args) {
        System.out.println(number);
    }
}
