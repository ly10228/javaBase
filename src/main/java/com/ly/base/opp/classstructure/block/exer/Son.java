package com.ly.base.opp.classstructure.block.exer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Son 由父及子 静态先行
 * @create 2019-11-14 22:35
 * @last modify by [LuoYong 2019-11-14 22:35]
 **/
public class Son extends Father {
    static {
        System.out.println("Son--static--block");
    }

    {
        System.out.println("Son--block");
    }

    public Son() {
        System.out.println("Son--构造方法");
    }


    /**
     * @param
     * @return void
     * @Description: 由父及子 静态先行
     * @author luoyong
     * @create 22:36 2019/11/14
     * @last modify by [LuoYong 22:36 2019/11/14 ]
     */
    @Test
    public void test() {
        System.out.println("begin");
        System.out.println("************************");
        new Son();
        System.out.println("************************");
        new Son();
        System.out.println("************************");
        new Father();
    }
}

class Father {
    static {
        System.out.println("Father--static--block");
    }

    {
        System.out.println("Father--block");
    }

    public Father() {
        System.out.println("Father--构造器");

    }

}