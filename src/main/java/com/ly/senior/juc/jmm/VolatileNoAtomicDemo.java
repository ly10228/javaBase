package com.ly.senior.juc.jmm;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyong
 *  * @create 2021-04-11 6:27 下午
 *  * @last modify by [luoyong 2021-04-11 6:27 下午]
 * @Description: volatile不保证原子性
 **/
public class VolatileNoAtomicDemo {
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
    }
}

class MyNumber {
    volatile int number = 0;

    public void addPlusPlus() {
        number++;
    }
}
