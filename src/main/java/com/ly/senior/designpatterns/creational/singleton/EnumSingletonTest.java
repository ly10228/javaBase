package com.ly.senior.designpatterns.creational.singleton;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 枚举--创建单例
 * 借助JDK 1.5当中添加的枚举来实现单例模式
 * 1：批量了多线程同步问题
 * 2：防止反序列化重新创建新的对象
 * 结论：推荐使用
 * @create 2019-09-07 23:20
 * @last modify by [LuoYong 2019-09-07 23:20]
 **/
public class EnumSingletonTest {
    @Test
    public void test() {
        System.out.println("枚举--线程安全和懒加载");
        EnumSingleton singletonOne = EnumSingleton.INSTANCE;
        EnumSingleton singletonOTwo = EnumSingleton.INSTANCE;
        //内存地址相同
        System.out.println(singletonOne == singletonOTwo);
        System.out.println("singletonOne.hashCode=" + singletonOne.hashCode());
        System.out.println("singletonOTwo.hashCode=" + singletonOTwo.hashCode());
    }
}


enum EnumSingleton {

    INSTANCE;

    private void show() {
        System.out.println("ok");
    }
}