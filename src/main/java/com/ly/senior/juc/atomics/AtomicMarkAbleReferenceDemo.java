package com.ly.senior.juc.atomics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author luoyong
 *  * @create 2021-04-18 4:06 下午
 *  * @last modify by [luoyong 2021-04-18 4:06 下午]
 * @Description: 原子更新带有标记位的引用类型对象
 **/
public class AtomicMarkAbleReferenceDemo {
    static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100, false);

    public static void main(String[] args) {
        new Thread(() -> {
            boolean marked = atomicMarkableReference.isMarked();
            System.out.println(Thread.currentThread().getName() + "\t" + "---默认修改标识：" + marked);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicMarkableReference.compareAndSet(100, 101, marked, !marked);
        }, "t1").start();

        new Thread(() -> {
            boolean marked = atomicMarkableReference.isMarked();
            System.out.println(Thread.currentThread().getName() + "\t" + "---默认修改标识：" + marked);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicMarkableReference.compareAndSet(100, 20210308, marked, !marked);

            System.out.println(Thread.currentThread().getName() + "\t" + "---操作是否成功:" + b);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicMarkableReference.getReference());
            System.out.println(Thread.currentThread().getName() + "\t" + atomicMarkableReference.isMarked());

        }, "t2").start();
    }
}
