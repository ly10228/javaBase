package com.ly.senior.jvm.classload.classuse;

import org.junit.Test;

import java.util.Random;

/**
 * @author luoyong
 *  * @create 2021-05-05 12:46 下午
 *  * @last modify by [luoyong 2021-05-05 12:46 下午]
 * @Description: 4. 当使用java.lang.reflect包中的方法反射类的方法时。比如：Class.forName("com.ly.senior.jvm.classload.classuse.Order")
 * 5. 当初始化子类时，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
 * 6. 如果一个接口定义了default方法，那么直接实现或者间接实现该接口的类的初始化，该接口要在其之前被初始化。
 * 7. 当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
 **/
public class ActiveUse3 {
    static {
        System.out.println("ActiveUse3的初始化过程");
    }

    @Test
    public void test1() {
        try {
            Class clazz = Class.forName("com.ly.senior.jvm.classload.classuse.Order");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        System.out.println(Son.num);
    }

    @Test
    public void test3() {
        System.out.println(CompareC.NUM1);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}

class Father {
    static {
        System.out.println("Father类的初始化过程");
    }
}

class Son extends Father implements CompareB {
    static {
        System.out.println("Son类的初始化过程");
    }

    public static int num = 1;
}

interface CompareB {
    public static final Thread t = new Thread() {
        {
            System.out.println("CompareB的初始化");
        }
    };

    public default void method1() {
        System.out.println("你好！");
    }

}

interface CompareC extends CompareB {
    public static final Thread t = new Thread() {
        {
            System.out.println("CompareC的初始化");
        }
    };

    public static final int NUM1 = new Random().nextInt();
}
