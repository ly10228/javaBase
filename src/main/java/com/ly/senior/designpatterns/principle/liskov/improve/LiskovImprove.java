package com.ly.senior.designpatterns.principle.liskov.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 里式替换原则
 * @create 2019-09-01 15:41
 * @last modify by [LuoYong 2019-09-01 15:41]
 **/
public class LiskovImprove {
    @Test
    public void test() {
        A a = new A();
        System.out.println("11-3=" + a.funcOne(11, 3));
        System.out.println("1-8=" + a.funcOne(1, 8));

        System.out.println("-----------------------");
        B b = new B();
        //因为B类不再继承A类，因此调用者，不会再funcOne是求减法
        //调用完成的功能就会很明确
        //这里本意是求出11+3
        System.out.println("11+3=" + b.funcOne(11, 3));
        // 1+8
        System.out.println("1+8=" + b.funcOne(1, 8));

        System.out.println("11+3+9=" + b.funcTwo(11, 3));

        //使用组合仍然可以使用到A类相关方法
        // 这里本意是求出11-3
        b.setA(a);
        System.out.println("11-3=" + b.funcThree(11, 3));

    }
}


/**
 * 创建一个更加基础的基类
 * 把更加基础的方法和成员写到Base类
 */
class Base {
}

/**
 * A类
 */
class A extends Base {
    /**
     * @param a
     * @param b
     * @return int
     * @Description: 返回两个数的差
     * @author luoyong
     * @create 15:43 2019/9/1
     * @last modify by [LuoYong 15:43 2019/9/1 ]
     */
    public int funcOne(int a, int b) {
        return a - b;
    }
}

class B extends Base {
    //如果B需要使用A类的方法,使用组合关系
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    //这里，重写了A类的方法, 可能是无意识
    public int funcOne(int a, int b) {
        return a + b;
    }

    public int funcTwo(int a, int b) {
        return funcOne(a, b) + 9;
    }

    //我们仍然想使用A的方法
    public int funcThree(int a, int b) {
        return this.a.funcOne(a, b);
    }
}