package com.ly.senior.juc.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luoyong
 *  * @create 2021-04-11 6:27 下午
 *  * @last modify by [luoyong 2021-04-11 6:27 下午]
 * @Description: volatile不保证原子性
 **/
public class VolatileNoAtomicDemo {

    /**
     * @param args
     * @return void
     * @Description: 为何数值总是加不到1万
     * @author luoyong
     * @create 8:48 下午 2021/6/19
     * @last modify by [LuoYong 8:48 下午 2021/6/19 ]
     */
    public static void main(String[] args) throws InterruptedException {
        MyNumber myNumber = new MyNumber();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myNumber.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.number);

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myNumber.atomicInteger.incrementAndGet();
                }
            }, String.valueOf(i)).start();
        }


        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.atomicInteger);

    }


}

class MyNumber {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    volatile int number = 0;

    public void addPlusPlus() {
        number++;
    }
}
