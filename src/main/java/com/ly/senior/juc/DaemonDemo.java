package com.ly.senior.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyong
 *  * @create 2021-04-04 12:07 上午
 *  * @last modify by [luoyong 2021-04-04 12:07 上午]
 * @Description: 守护线程&用户线程
 * 守护线程：是一种特殊的线程，在后台默默地完成一些系统性的服务，比如垃圾回收线程
 * 用户线程: 是系统的工作线程，它会完成这个程序需要完成的业务操作
 * 当程序中所有用户线程执行完毕之后，不管守护线程是否结束，系统都会自动退出
 * 如果用户线程全部结束了，意味着程序需要完成的业务操作已经结束了，系统可以退出了。所以当系统只剩下守护进程的时候，java虚拟机会自动退出
 * 设置守护线程，需要在start()方法之前进行
 **/
public class DaemonDemo {
    public static void main(String[] args) {
        //1 a是用户线程
//        Thread a = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + " come in:" + (Thread.currentThread().isDaemon() ?
//                    "守护线程" : "用户线程"));
//            while (true) {
//
//            }
//        }, "a");
//        a.start();
//        System.out.println(Thread.currentThread().getName() + "--task is over");


        //2:将a变成守护线程
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in：\t"
                    + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            while (true) {

            }
        }, "a");
        a.setDaemon(true);
        a.start();

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "\t" + " ----task is over");
    }
}
