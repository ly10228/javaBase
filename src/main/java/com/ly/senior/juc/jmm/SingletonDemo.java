package com.ly.senior.juc.jmm;

/**
 * @author luoyong
 *  * @create 2021-04-11 10:00 下午
 *  * @last modify by [luoyong 2021-04-11 10:00 下午]
 * @Description: SingletonDemo 静态内部类
 **/
public class SingletonDemo {
    private SingletonDemo() {
    }

    private static class SingletonDemoHandler {
        private static SingletonDemo instance = new SingletonDemo();
    }

    public static SingletonDemo getInstance() {
        return SingletonDemoHandler.instance;
    }
}
