package com.ly.senior.designpatterns.creational.singleton.eager;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 饿汉式--静态变量
 * 优点：这种写法比较简单，就是在类装载的时候完成实例化，避免了线程同步的问题
 * 缺点：在类装载的时候就完成了实例化 没有达到Lazy Loading的效果,如果从始至终没有使用过这个类 造成内存浪费
 * 结论：这种单例模式可用，可能造成内存的浪费（如果确定这个类一定会使用到 这样写）
 * @create 2019-09-07 21:31
 * @last modify by [LuoYong 2019-09-07 21:31]
 **/
public class StaticVariableSingletonTest {

    /**
     * @param
     * @return void
     * @Description: 测试--饿汉式--静态变量
     * @author luoyong
     * @create 21:33 2019/9/7
     * @last modify by [LuoYong 21:33 2019/9/7 ]
     */
    @Test
    public void test() {
        StaticVariableSingleton singletonOne = StaticVariableSingleton.getInstance();
        StaticVariableSingleton singletonOTwo = StaticVariableSingleton.getInstance();
        //内存地址相同
        System.out.println(singletonOne == singletonOTwo);
        System.out.println("singletonOne.hashCode=" + singletonOne.hashCode());
        System.out.println("singletonOTwo.hashCode=" + singletonOTwo.hashCode());
    }
}


class StaticVariableSingleton {

    /**
     * 1.构造器私有化, 外部不能new
     */
    private StaticVariableSingleton() {

    }

    /**
     * 2.本类内部创建对象实例
     */
    private final static StaticVariableSingleton instance = new StaticVariableSingleton();

    /**
     * @param
     * @return
     * @Description: 提供一个公有的静态方法，返回实例对象
     * @author luoyong
     * @create 21:33 2019/9/7
     * @last modify by [LuoYong 21:33 2019/9/7 ]
     */
    public static StaticVariableSingleton getInstance() {
        return instance;
    }

}