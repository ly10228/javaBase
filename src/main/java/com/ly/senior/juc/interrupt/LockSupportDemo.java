package com.ly.senior.juc.interrupt;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoyong
 *  * @create 2021-04-11 3:21 下午
 *  * @last modify by [luoyong 2021-04-11 3:21 下午]
 * @Description: LockSupportDemo
 **/
public class LockSupportDemo {
    static Object objectLock = new Object();

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        parkUnPark();
//        syncWaitNotify();
//        lockAwaitSignal();

    }

    /**
     * @return void
     * @Description: 停两次释放两次 用多个线程来释放
     * @author luoyong
     * @create 11:02 上午 2021/6/19
     * @last modify by [LuoYong 11:02 上午 2021/6/19 ]
     */
    public static void parkUnPark() {
        //非阻塞的 无锁化通知
        Thread t1 = new Thread(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
        }, "t1");
        t1.start();

        new Thread(() -> {
            LockSupport.unpark(t1);

            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //停2次
        new Thread(() -> {
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
        }, "t3").start();
    }

    /**
     * @return void
     * @Description: 一个LockSupport.park()要一个unPark()  LockSupport.unpark(t1)写在一起也就是一个通行证 最大累加值是1
     * 注意：一个线程只能针对某一个线程发送一次通行证
     * 非阻塞的---无锁化通知机制
     * @author luoyong
     * @create 10:48 上午 2021/6/19
     * @last modify by [LuoYong 10:48 上午 2021/6/19 ]
     */
    @Test
    public void testParkUnParkEx() {
        //非阻塞的 无锁化通知
        Thread t1 = new Thread(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
        }, "t1");
        t1.start();

        new Thread(() -> {
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
        }, "t2").start();


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Description: Condition中的线程等待和唤醒方法之前，需要先获取锁  一定要先await后signal，不要反了
     * @author luoyong
     * @create 3:27 下午 2021/4/11
     * @last modify by [LuoYong 3:27 下午 2021/4/11 ]
     */
    public static void lockAwaitSignal() {
        new Thread(() -> {
            //暂停几秒钟线程
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }


    /**
     * @return void
     * @Description: wait和notify方法必须要在同步块或者方法里面，且成对出现使用 先wait后notify才OK
     * @author luoyong
     * @create 3:27 下午 2021/4/11
     * @last modify by [LuoYong 3:27 下午 2021/4/11 ]
     */
    public static void syncWaitNotify() {
        new Thread(() -> {
            //暂停几秒钟线程
            try {
//                TimeUnit.SECONDS.sleep(3); wait()必须要在notify()之前执行
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
            }
        }, "t1").start();

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
            }
        }, "t2").start();
    }
}
