package com.ly.senior.designpatterns.creational.singleton;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 懒汉式--双重检查
 * 在多线程开发当中经常使用到
 * 优点：线程安全 延迟加载 效率较高
 * 结论：在实际开发当中，推荐使用这种单例设计模式
 * @create 2019-09-07 22:28
 * @last modify by [LuoYong 2019-09-07 22:28]
 **/
public class DoubleCheckSingletonTest {

    /**
     * @param
     * @return void
     * @Description: 测试双重检查实现单例
     * @author luoyong
     * @create 22:35 2019/9/7
     * @last modify by [LuoYong 22:35 2019/9/7 ]
     */
    @Test
    public void test() {
        System.out.println("双重检查--线程安全和懒加载");
        Singleton singletonOne = Singleton.getInstance();
        Singleton singletonOTwo = Singleton.getInstance();
        //内存地址相同
        System.out.println(singletonOne == singletonOTwo);
        System.out.println("singletonOne.hashCode=" + singletonOne.hashCode());
        System.out.println("singletonOTwo.hashCode=" + singletonOTwo.hashCode());
    }
}


class Singleton {

    private Singleton() {
    }

    /**
     * 本类内部创建对象实例
     * volatile
     * 1:保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的（实现可见性）
     * 2:禁止进行指令重排序。（实现有序性）
     * 3:只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性
     */
    private static volatile Singleton singleton;

    /**
     * @param
     * @return
     * @Description: 双重检查 既达到了线程安全，又实现了懒加载
     * @author luoyong
     * @create 22:21 2019/9/7
     * @last modify by [LuoYong 22:21 2019/9/7 ]
     */
    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}