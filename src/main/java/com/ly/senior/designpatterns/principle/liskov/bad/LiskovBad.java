package com.ly.senior.designpatterns.principle.liskov.bad;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: LiskovBad 里式替换原则
 * @create 2019-09-01 11:05
 * @last modify by [LuoYong 2019-09-01 11:05]
 **/
public class LiskovBad {
    @Test
    public void test() {
        A a = new A();
        System.out.println("11-3=" + a.funcOne(11, 3));
        System.out.println("1-8=" + a.funcOne(1, 8));

        System.out.println("-----------------------");
        B b = new B();
        //这里本意是求出11-3 但是B重写了funcOne方法
        System.out.println("11-3=" + b.funcOne(11, 3));
        // 1-8
        System.out.println("1-8=" + b.funcOne(1, 8));
        System.out.println("11+3+9=" + b.funcTwo(11, 3));


    }
}

class A {
    public int funcOne(int numOne, int numTwo) {
        return numOne - numTwo;
    }
}


/**
 * B类继承了A 重写了funcOne方法
 * 增加了一个新功能：完成两个数相加,然后和9求和
 */
class B extends A {
    /**
     * 这里，重写了A类的方法, 可能是无意识
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int funcOne(int a, int b) {
        return a + b;
    }

    public int funcTwo(int a, int b) {
        return funcOne(a, b) + 9;
    }
}