package com.ly.senior.juc.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoyong
 *  * @create 2021-04-05 9:18 下午
 *  * @last modify by [luoyong 2021-04-05 9:18 下午]
 * @Description: 公平锁非公平锁案例
 * 按序排队公平锁，就是判断同步队列是否还有先驱节点的存在(我前面还有人吗?)，如果没有先驱节点才能获取锁；
 * 先占先得非公平锁，是不管这个事的，只要能抢获到同步状态就可以
 **/
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 1; i <= 55; i++) ticket.sale();
        }, "a").start();
        new Thread(() -> {
            for (int i = 1; i <= 55; i++) ticket.sale();
        }, "b").start();
        new Thread(() -> {
            for (int i = 1; i <= 55; i++) ticket.sale();
        }, "c").start();
        new Thread(() -> {
            for (int i = 1; i <= 55; i++) ticket.sale();
        }, "d").start();
        new Thread(() -> {
            for (int i = 1; i <= 55; i++) ticket.sale();
        }, "e").start();
    }
}


class Ticket {
    private int number = 50;

    //默认用的是非公平锁，分配的平均一点，=--》公平一点
    private Lock lock = new ReentrantLock(true);

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第: " + (number--) + "\t 还剩下: " + number);
            }
        } finally {
            lock.unlock();
        }
    }


    /*Object objectLock = new Object();
    public void sale()
    {
        synchronized (objectLock)
        {
            if(number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"\t 卖出第: "+(number--)+"\t 还剩下: "+number);
            }
        }
    }*/
}