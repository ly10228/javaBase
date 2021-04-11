package com.ly.senior.juc.interrupt;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author luoyong
 *  * @create 2021-04-05 10:32 下午
 *  * @last modify by [luoyong 2021-04-05 10:32 下午]
 * @Description: 中断一个线程
 **/
public class InterruptDemo {
    static volatile boolean isStop = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
        System.out.println("111111");
        Thread.currentThread().interrupt();///----false---> true
        System.out.println("222222");
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "---" + Thread.interrupted());
    }

    /**
     * @return void
     * @Description: 通过一个volatile变量 中断一个线程
     * @author luoyong
     * @create 10:35 下午 2021/4/5
     * @last modify by [LuoYong 10:35 下午 2021/4/5 ]
     */
    @Test
    public void m1() {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println("-----isStop = true，程序结束。");
                    break;
                }
                System.out.println("------hello isStop");
            }
        }, "t1").start();

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            isStop = true;
        }, "t2").start();
    }

    /**
     * @return void
     * @Description: 通过AtomicBoolean 中断一个线程
     * @author luoyong
     * @create 10:33 下午 2021/4/5
     * @last modify by [LuoYong 10:33 下午 2021/4/5 ]
     */
    @Test
    public void m2() {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    System.out.println("-----atomicBoolean.get() = true，程序结束。");
                    break;
                }
                System.out.println("------hello atomicBoolean");
            }
        }, "t1").start();

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            atomicBoolean.set(true);
        }, "t2").start();
    }

    /**
     * @return void
     * @Description: 过interrupt()方法 中断一个线程
     * @author luoyong
     * @create 10:34 下午 2021/4/5
     * @last modify by [LuoYong 10:34 下午 2021/4/5 ]
     */
    @Test
    public void m3() {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("-----isInterrupted() = true，程序结束。");
                    break;
                }
                System.out.println("------hello Interrupt");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            t1.interrupt();//修改t1线程的中断标志位为true
        }, "t2").start();
    }


    /**
     * @return void
     * @Description: 中断为true之后 不是立刻stop
     * @author luoyong
     * @create 10:46 下午 2021/4/5
     * @last modify by [LuoYong 10:46 下午 2021/4/5 ]
     */
    public static void m4() {
        //中断为true后，并不是立刻stop程序
        Thread t1 = new Thread(() -> {
            //设置次数足够大时 才出现（1.interrupt()调用之后01：true）
            for (int i = 1; i <= 10000; i++) {
                System.out.println("------i: " + i);
            }
            System.out.println("t1.interrupt()调用之后02： " + Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();

        System.out.println("t1.interrupt()调用之前,t1线程的中断标识默认值： " + t1.isInterrupted());
        try {
            TimeUnit.MILLISECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //实例方法interrupt()仅仅是设置线程的中断状态位设置为true，不会停止线程
        t1.interrupt();
        //活动状态,t1线程还在执行中
        System.out.println("t1.interrupt()调用之后01： " + t1.isInterrupted());

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //非活动状态,t1线程不在执行中，已经结束执行了。
        System.out.println("t1.interrupt()调用之后03： " + t1.isInterrupted());
    }


    /**
     * @return void
     * @Description: 使用过interrupt()中断线程的时候 wait sleep join几种状态下会报异常
     * @author luoyong
     * @create 11:05 下午 2021/4/5
     * @last modify by [LuoYong 11:05 下午 2021/4/5 ]
     */
    public static void m5() {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("-----isInterrupted() = true，程序结束。");
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //???????  //线程的中断标志位为false,无法停下，需要再次掉interrupt()设置true
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("------hello Interrupt");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            //修改t1线程的中断标志位为true
            t1.interrupt();
        }, "t2").start();
    }

}
