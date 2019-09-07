package com.ly.senior.designpatterns.creational.singleton.eager;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 饿汉式--静态代码块
 * 优缺点同静态方法
 * @create 2019-09-07 21:45
 * @last modify by [LuoYong 2019-09-07 21:45]
 **/
public class StaticBlockSingletonTest {

    /**
     * @param
     * @return void
     * @Description: 饿汉式--静态代码块--测试
     * @author luoyong
     * @create 21:51 2019/9/7
     * @last modify by [LuoYong 21:51 2019/9/7 ]
     */
    @Test
    public void test() {
        Singleton singletonOne = Singleton.getInstance();
        Singleton singletonOTwo = Singleton.getInstance();
        //内存地址相同
        System.out.println(singletonOne == singletonOTwo);
        System.out.println("singletonOne.hashCode=" + singletonOne.hashCode());
        System.out.println("singletonOTwo.hashCode=" + singletonOTwo.hashCode());
    }
}


/**
 * 饿汉式(静态变量)
 */
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

    static {
        // 在静态代码块中，创建单例对象
        instance = new Singleton();
    }

    /**
     * @param
     * @return
     * @Description: 提供一个公有的静态方法，返回实例对象
     * @author luoyong
     * @create 21:51 2019/9/7
     * @last modify by [LuoYong 21:51 2019/9/7 ]
     */
    public static Singleton getInstance() {
        return instance;
    }

}