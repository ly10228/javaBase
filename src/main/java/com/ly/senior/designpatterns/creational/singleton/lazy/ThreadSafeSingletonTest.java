package com.ly.senior.designpatterns.creational.singleton.lazy;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 懒汉式--线程安全
 * 解决了线程安全的问题
 * 缺点--效率太低，每个线程想获取该类的实例的时候 getInstance都要同步。
 * 结论：在实际开发当中 不推荐使用这种方式
 * @create 2019-09-07 22:08
 * @last modify by [LuoYong 2019-09-07 22:08]
 **/
public class ThreadSafeSingletonTest {

    /**
     * @param
     * @return void
     * @Description: 懒汉式--线程安全--加入同步处理代码--测试
     * @author luoyong
     * @create 22:02 2019/9/7
     * @last modify by [LuoYong 22:02 2019/9/7 ]
     */
    @Test
    public void test() {
        System.out.println("懒汉式--线程安全");
        SingletonSafe singletonOne = SingletonSafe.getInstance();
        SingletonSafe singletonOTwo = SingletonSafe.getInstance();
        //内存地址相同
        System.out.println(singletonOne == singletonOTwo);
        System.out.println("singletonOne.hashCode=" + singletonOne.hashCode());
        System.out.println("singletonOTwo.hashCode=" + singletonOTwo.hashCode());
    }
}


class SingletonSafe {

    /**
     * 构造器私有化, 外部能new
     */
    private SingletonSafe() {

    }


    /**
     * 本类内部创建对象实例
     */
    private static SingletonSafe instance;

    /**
     * @param
     * @return
     * @Description: 提供一个公有的静态方法，返回实例对象
     * 调用的时候创建
     * 加入同步处理的代码--解决线程安全问题
     * @author luoyong
     * @create 21:51 2019/9/7
     * @last modify by [LuoYong 21:51 2019/9/7 ]
     */
    public static synchronized SingletonSafe getInstance() {
        if (null == instance) {
            instance = new SingletonSafe();
        }
        return instance;
    }

    /**
     * @param
     * @return
     * @Description: 这种方本意是对第四种方式进行改进，改成同步产生实例的化的代码块
     * 缺点：这种方式不能保证线程同步。也可能产生多个实例
     * 结论：在实际开发当中，不能使用这种方式
     * @author luoyong
     * @create 22:21 2019/9/7
     * @last modify by [LuoYong 22:21 2019/9/7 ]
     */
    public static SingletonSafe getInstanceUnSafe() {
        if (null == instance) {
            synchronized (SingletonSafe.class) {
                instance = new SingletonSafe();
            }
        }
        return instance;
    }
}