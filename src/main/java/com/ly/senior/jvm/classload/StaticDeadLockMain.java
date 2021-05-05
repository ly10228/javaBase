package com.ly.senior.jvm.classload;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyong
 *  * @create 2021-05-05 11:47 上午
 *  * @last modify by [luoyong 2021-05-05 11:47 上午]
 * @Description: <clinit>死锁问题
 **/
public class StaticDeadLockMain extends Thread {
    private char flag;

    public StaticDeadLockMain(char flag) {
        this.flag = flag;
        this.setName("Thread" + flag);
    }

    @Override
    public void run() {
        try {
            Class.forName("com.ly.senior.jvm.classload.Static" + flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " over");
    }

    public static void main(String[] args) throws InterruptedException {
        StaticDeadLockMain loadA = new StaticDeadLockMain('A');
        loadA.start();
        StaticDeadLockMain loadB = new StaticDeadLockMain('B');
        loadB.start();
    }
}

class StaticA {
    static {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName("com.ly.senior.jvm.classload.StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticA init OK");
    }
}


class StaticB {
    static {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName("com.ly.senior.jvm.classload.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticB init OK");
    }
}