package com.ly.base.opp.classstructure.block.exer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: LeafTest 总结：由父及子，静态先行
 * @create 2019-11-14 22:42
 * @last modify by [LuoYong 2019-11-14 22:42]
 **/
public class LeafTest {
    @Test
    public void test() {
        new Leaf();
        System.out.println();
        new Leaf();
    }
}

class Root {
    static {
        System.out.println("Root--static--block");
    }

    {
        System.out.println("Root--block");
    }

    public Root() {
        super();
        System.out.println("Root--无参数的构造器");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid的静态初始化块");
    }

    {
        System.out.println("Mid的普通初始化块");
    }

    public Mid() {
        super();
        System.out.println("Mid的无参数的构造器");
    }

    public Mid(String msg) {
        //通过this调用同一类中重载的构造器
        this();
        System.out.println("Mid的带参数构造器，其参数值："
                + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf的静态初始化块");
    }

    {
        System.out.println("Leaf的普通初始化块");
    }

    public Leaf() {
        //通过super调用父类中有一个字符串参数的构造器
        super("尚硅谷");
        System.out.println("Leaf的构造器");
    }
}