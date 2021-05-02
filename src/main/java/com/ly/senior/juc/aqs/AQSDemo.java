package com.ly.senior.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoyong
 *  * @create 2021-05-02 2:02 下午
 *  * @last modify by [luoyong 2021-05-02 2:02 下午]
 * @Description: AQSDemo
 **/
public class AQSDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        //A B C 三个顾客去银行办理业务 A 先到 此时窗口空无一人 他优先获取办理窗口的机会

        //A是第一个  长期占有窗口
        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("------->come in A");
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }, "A").start();


        //B是第二个 B看到办理窗口已经被A占用了，只能去候客区等待 进入AQS队列 等待着A办理完成 尝试着去抢占窗口
        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("------->come in B");
            } finally {
                reentrantLock.unlock();
            }
        }, "B").start();

        //C是第3个，C一看到受理窗口被A占用，只能去候客区等待，进入AQS队列，等待着A办理完成，尝试去抢占受理窗口,前面是B顾客，FIFO
        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("------->come in C");
            } finally {
                reentrantLock.unlock();
            }
        }, "C").start();
    }
}
