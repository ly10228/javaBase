package com.ly.senior.designpatterns.creational.singleton;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 静态内部类--创建单例
 * @create 2019-09-07 23:09
 * @last modify by [LuoYong 2019-09-07 23:09]
 **/
public class StaticInnerClassesSingletonTest {
    /**
     * @param
     * @return void
     * @Description: 静态内部类--创建单例--推荐
     * @author luoyong
     * @create 23:22 2019/9/7
     * @last modify by [LuoYong 23:22 2019/9/7 ]
     */
    @Test
    public void test() {
        System.out.println("静态内部类--线程安全和懒加载");
        StaticInnerSingleton singletonOne = StaticInnerSingleton.getInstance();
        StaticInnerSingleton singletonOTwo = StaticInnerSingleton.getInstance();
        //内存地址相同
        System.out.println(singletonOne == singletonOTwo);
        System.out.println("singletonOne.hashCode=" + singletonOne.hashCode());
        System.out.println("singletonOTwo.hashCode=" + singletonOTwo.hashCode());
    }
}

class StaticInnerSingleton {

    private StaticInnerSingleton() {
    }


    /**
     * 静态内部类
     * 1：StaticInnerSingleton 在装载的时候不会装载StaticInnerSingletonInit
     * 2：jvm在装载类的时候是线程安全的
     * 类的静态属性只会在第一次加载的时候初始化
     * 推荐使用
     */
    private static class StaticInnerSingletonInit {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return StaticInnerSingletonInit.INSTANCE;
    }
}
