package com.ly.senior.juc.jmm;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyong
 *  * @create 2021-04-11 6:13 下午
 *  * @last modify by [luoyong 2021-04-11 6:13 下午]
 * @Description: VolatileSeeDemo
 **/
public class VolatileSeeDemo {

    public static void main(String[] args) {
        m1();
//        m2();
    }

    //加了volatile，保证可见性
    static volatile boolean flag = true;

    /**
     * @return void
     * @Description: flag修改之后 会立即刷新回主存 同时其他线程本地的这个flag变量失效 重新从主存当中获取
     * @author luoyong
     * @create 3:56 下午 2021/6/19
     * @last modify by [LuoYong 3:56 下午 2021/6/19 ]
     */
    public static void m1() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            while (flag) {
                new Integer(308);
                System.out.println("flag===" + flag);
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

    //不加volatile，没有可见性
    static boolean commonFlag = true;

    /**
     * @return void
     * @Description: commonFlag 没有内存可见性 线程t1会一直运行下去
     * @author luoyong
     * @create 3:54 下午 2021/6/19
     * @last modify by [LuoYong 3:54 下午 2021/6/19 ]
     */
    public static void m2() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            while (commonFlag) {
                new Integer(308);
                System.out.println("commonFlag===" + commonFlag);
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
