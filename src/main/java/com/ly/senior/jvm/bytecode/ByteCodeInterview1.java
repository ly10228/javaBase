package com.ly.senior.jvm.bytecode;

/**
 * @author luoyong
 *  * @create 2021-05-03 8:49 下午
 *  * @last modify by [luoyong 2021-05-03 8:49 下午]
 * @Description: ByteCodeInterview1
 **/
public class ByteCodeInterview1 {
    public static void main(String[] args) {
        Father f = new Son();
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

    public Son() {
        this.print();
        x = 40;
    }

    public void print() {
        System.out.println("Son.x = " + x);
    }
}
