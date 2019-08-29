package com.ly.senior.designpatterns.principle.segregation.bad;

/**
 * @author luoyong
 * @Description: SegregationBad
 * @create 2019-08-29 8:03
 * @last modify by [LuoYong 2019-08-29 8:03]
 **/
public class SegregationBad {
}

interface InterfaceBad {
    void operationOne();

    void operationTwo();

    void operationThree();

    void operationFour();

    void operationFive();
}

class B implements InterfaceBad {
    public void operationOne() {
        System.out.println("B 实现了 operation1");
    }

    public void operationTwo() {
        System.out.println("B 实现了 operation2");
    }

    public void operationThree() {
        System.out.println("B 实现了 operation3");
    }

    public void operationFour() {
        System.out.println("B 实现了 operation4");
    }

    public void operationFive() {
        System.out.println("B 实现了 operation5");
    }
}

class D implements InterfaceBad {
    public void operationOne() {
        System.out.println("D 实现了 operation1");
    }

    public void operationTwo() {
        System.out.println("D 实现了 operation2");
    }

    public void operationThree() {
        System.out.println("D 实现了 operation3");
    }

    public void operationFour() {
        System.out.println("D 实现了 operation4");
    }

    public void operationFive() {
        System.out.println("D 实现了 operation5");
    }
}

/**
 * A 类通过接口Interface1 依赖(使用) B类，但是只会用到1,2,3方法
 */
class A {
    public void dependOne(InterfaceBad i) {
        i.operationOne();
    }

    public void dependTwo(InterfaceBad i) {
        i.operationTwo();
    }

    public void dependThree(InterfaceBad i) {
        i.operationThree();
    }
}

/**
 * C 类通过接口Interface1 依赖(使用) D类，但是只会用到1,4,5方法
 */
class C {
    public void dependOne(InterfaceBad i) {
        i.operationOne();
    }

    public void dependFour(InterfaceBad i) {
        i.operationFour();
    }

    public void dependFive(InterfaceBad i) {
        i.operationFive();
    }
}