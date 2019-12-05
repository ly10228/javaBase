package com.ly.base.opp.classstructure.keyword.interfacekey.exer;

/**
 * @author luoyong
 * @Description: C
 * @create 2019-11-20 22:27
 * @last modify by [LuoYong 2019-11-20 22:27]
 **/
public class C extends B implements A {
    public void pX() {
        //编译不通过。因为x是不明确的
        // System.out.println(x);
        //1
        System.out.println(super.x);
        //0
        System.out.println(A.x);
        System.out.println(x1);
        System.out.println(x2);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}

interface A {
    // public static final int x=0;
    int x = 0;
    int x1 = 3;
}

class B {
    int x = 1;
    int x2 = 4;
}
