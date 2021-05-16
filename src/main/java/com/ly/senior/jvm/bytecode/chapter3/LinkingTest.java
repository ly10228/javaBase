package com.ly.senior.jvm.bytecode.chapter3;

/**
 * @author luoyong
 *  * @create 2021-05-16 11:58 上午
 *  * @last modify by [luoyong 2021-05-16 11:58 上午]
 * @Description: 过程二：链接阶段（验证-准备-解析）
 * 基本数据类型：非final修饰的变量，在准备环节进行默认初始化赋值。
 * final修饰以后，在准备环节直接进行显示赋值。
 * 拓展：如果使用字面量的方式定义一个字符串的常量的话，也是在准备环节直接进行显示赋值。
 **/
public class LinkingTest {
    private static long id;
    private static final int num = 1;

    public static final String constStr = "CONST";
    public static final String constStr1 = new String("CONST");

    public Object getObj() {
        return null;
    }

    public void print1() {
        System.out.println("hello");
    }
}
