package com.ly.senior.juc.rwlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luoyong
 *  * @create 2021-05-02 9:30 下午
 *  * @last modify by [luoyong 2021-05-02 9:30 下午]
 * @Description: 读写锁
 **/
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        //资源类
        MyResource myResource = new MyResource();

        //写
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {
                myResource.write(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }

        //读
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {
                myResource.read(finalI + "");
            }, String.valueOf(i)).start();
        }

        //readLock.unlock()之后 其他线程才能写
        for (int i = 1; i <= 3; i++) {
            int finalI = i;
            new Thread(() -> {
                myResource.write(finalI + "", finalI + "");
            }, "ly" + String.valueOf(i)).start();
        }
    }
}

class MyResource {

    Map<String, String> map = new HashMap<>();

    //=====ReentrantLock 等价于 =====synchronized
    Lock lock = new ReentrantLock();

    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void write(String key, String value) {
        rwLock.writeLock().lock();
//        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "---正在写入");
            map.put(key, value);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "---完成写入");
        } finally {
//            lock.unlock();
            rwLock.writeLock().unlock();
        }
    }

    public void read(String key) {
//        lock.lock();
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "---正在读取");
            String result = map.get(key);
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "---完成读取result： " + result);
        } finally {
//            lock.unlock();
            rwLock.readLock().unlock();
        }
    }
}
