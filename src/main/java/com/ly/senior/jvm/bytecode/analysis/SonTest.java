package com.ly.senior.jvm.bytecode.analysis;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2021-05-09 2:23 下午
 *  * @last modify by [luoyong 2021-05-09 2:23 下午]
 * @Description: 字节码分析
 * 成员变量（非静态的）的赋值过程：① 默认初始化 - ② 显式初始化 /代码块中初始化 - ③ 构造器中初始化 - ④ 有了对象之后，可以“对象.属性”或"对象.方法"的方式对成员变量进行赋值
 **/
public class SonTest {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.x);
    }

    @Test
    public void test() {
        Father f = new Father();
        System.out.println(f.x);
    }
}


class Father {
    int x = 10;

    public Father() {
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("Father.x = " + x);
    }
}

class Son extends Father {
    int x = 30;

    //    float x = 30.1F;
    public Son() {
        this.print();
        x = 40;
    }

    public void print() {
        System.out.println("Son.x = " + x);
    }
}