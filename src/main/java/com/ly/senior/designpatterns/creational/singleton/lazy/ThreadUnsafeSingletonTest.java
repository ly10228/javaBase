package com.ly.senior.designpatterns.creational.singleton.lazy;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 懒汉式--线程不安全
 * 起到了Lazy Loading的效果 但是只能在单线程下使用
 * 在多线程的环境下可能产生多个实例
 * 结论：在实际开发当中，不要使用这种方式
 * @create 2019-09-07 22:00
 * @last modify by [LuoYong 2019-09-07 22:00]
 **/
public class ThreadUnsafeSingletonTest {

    /**
     * @param
     * @return void
     * @Description: 懒汉式--线程不安全--测试
     * @author luoyong
     * @create 22:02 2019/9/7
     * @last modify by [LuoYong 22:02 2019/9/7 ]
     */
    @Test
    public void test() {
        System.out.println("懒汉式--线程不安全");
        Singleton singletonOne = Singleton.getInstance();
        Singleton singletonOTwo = Singleton.getInstance();
        //内存地址相同
        System.out.println(singletonOne == singletonOTwo);
        System.out.println("singletonOne.hashCode=" + singletonOne.hashCode());
        System.out.println("singletonOTwo.hashCode=" + singletonOTwo.hashCode());
    }
}

class Singleton {

    /**
     * 构造器私有化, 外部能new
     */
    private Singleton() {

    }


    /**
     * 本类内部创建对象实例
     */
    private static Singleton instance;

    /**
     * @param
     * @return
     * @Description: 提供一个公有的静态方法，返回实例对象
     * 调用的时候创建
     * @author luoyong
     * @create 21:51 2019/9/7
     * @last modify by [LuoYong 21:51 2019/9/7 ]
     */
    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

}