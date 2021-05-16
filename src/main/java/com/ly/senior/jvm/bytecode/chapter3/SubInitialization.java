package com.ly.senior.jvm.bytecode.chapter3;

/**
 * @author luoyong
 *  * @create 2021-05-16 12:23 下午
 *  * @last modify by [luoyong 2021-05-16 12:23 下午]
 * @Description: SubInitialization
 **/
public class SubInitialization extends InitializationTest {
    static {
        number = 4;//number属性必须提前已经加载：一定会先加载父类。
        System.out.println("son static{}");
    }

    public static void main(String[] args) {
        System.out.println(number);
    }
}
