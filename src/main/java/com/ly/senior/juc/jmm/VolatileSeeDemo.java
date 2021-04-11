package com.ly.senior.juc.jmm;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyong
 *  * @create 2021-04-11 6:13 下午
 *  * @last modify by [luoyong 2021-04-11 6:13 下午]
 * @Description: VolatileSeeDemo
 **/
public class VolatileSeeDemo {
    //不加volatile，没有可见性
    //static          boolean flag = true;
    //加了volatile，保证可见性
    static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            while (flag) {
                new Integer(308);
            }
            System.out.println("t1 over");
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            flag = false;
        }, "t2").start();
    }
}
