package com.ly.senior.designpatterns.principle.segregation.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: SegregationImprove
 * @create 2019-08-29 22:53
 * @last modify by [LuoYong 2019-08-29 22:53]
 **/
public class SegregationImprove {

    /**
     * @param
     * @return void
     * @Description: 测试接口隔离原则
     * @author luoyong
     * @create 23:01 2019/8/29
     * @last modify by [LuoYong 23:01 2019/8/29 ]
     */
    @Test
    public void test() {
        // A类通过接口去依赖B类
        A a = new A();
        a.dependOne(new B());
        a.dependTwo(new B());
        a.dependThree(new B());

        //C类通过接口去依赖(使用)D类
        C c = new C();
        c.dependOne(new D());
        c.dependFour(new D());
        c.dependFive(new D());
    }
}


/**
 * 接口1
 */
interface InterfaceOne {
    void operationOne();
}

/**
 * 接口2
 */
interface InterfaceTwo {
    void operationTwo();

    void operationThree();
}

/**
 * 接口3
 */
interface InterfaceThree {
    void operationFour();

    void operationFive();
}


class B implements InterfaceOne, InterfaceTwo {
    public void operationOne() {
        System.out.println("B 实现了 operationOne");
    }

    public void operationTwo() {
        System.out.println("B 实现了 operationTwo");
    }

    public void operationThree() {
        System.out.println("B 实现了 operationThree");
    }

}

class D implements InterfaceOne, InterfaceThree {
    @Override
    public void operationOne() {
        System.out.println("D 实现了operationOne");
    }

    @Override
    public void operationFour() {
        System.out.println("D 实现了 operationFour");
    }

    @Override
    public void operationFive() {
        System.out.println("D 实现了 operationFive");
    }
}

/**
 * A 类通过接口Interface1,Interface2 依赖(使用) B类，但是只会用到1,2,3方法
 */
class A {
    public void dependOne(InterfaceOne i) {
        i.operationOne();
    }

    public void dependTwo(InterfaceTwo i) {
        i.operationTwo();
    }

    public void dependThree(InterfaceTwo i) {
        i.operationThree();
    }

}

/**
 * C 类通过接口Interface1,Interface3 依赖(使用) D类，但是只会用到1,4,5方法
 */
class C {
    public void dependOne(InterfaceOne i) {
        i.operationOne();
    }

    public void dependFour(InterfaceThree i) {
        i.operationFour();
    }

    public void dependFive(InterfaceThree i) {
        i.operationFive();
    }
}