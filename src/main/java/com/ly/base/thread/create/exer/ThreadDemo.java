package com.ly.base.thread.create.exer;

/**
 * @author luoyong
 * @Description: ThreadDemo
 * @create 2019-11-25 22:27
 * @last modify by [LuoYong 2019-11-25 22:27]
 **/
public class ThreadDemo {

    public static void main(String[] args) {
        TraversingEvenNum t1 = new TraversingEvenNum();
        t1.start();

        ErgodicOddNum t2 = new ErgodicOddNum();
        t2.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if (i % 2 == 0) {
                        //输出偶数
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if (i % 2 != 0) {
                        //输出奇数
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

class TraversingEvenNum extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                //输出偶数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


class ErgodicOddNum extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                //输出奇数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}