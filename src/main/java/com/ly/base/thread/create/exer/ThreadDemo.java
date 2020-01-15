package com.ly.base.thread.create.exer;

import com.ly.utils.MathUtils;

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
                //输出100以内的偶数
                MathUtils.printEven();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                //数据100以内的奇数
                MathUtils.printOddNumber();
            }
        }.start();
    }
}

class TraversingEvenNum extends Thread {
    @Override
    public void run() {
        //输出100以内的偶数
        MathUtils.printEven();
    }
}


class ErgodicOddNum extends Thread {
    @Override
    public void run() {
        //数据100以内的奇数
        MathUtils.printOddNumber();
    }
}