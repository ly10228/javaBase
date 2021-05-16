package com.ly.senior.jvm.bytecode.chapter2;

/**
 * @author luoyong
 *  * @create 2021-05-16 10:40 上午
 *  * @last modify by [luoyong 2021-05-16 10:40 上午]
 * @Description: 指令9：同步控制指令
 * add和add1字节完全一样 区别在访问标识
 **/
public class SynchronizedTest {
    private int i = 0;

    public void add() {
        i++;
    }


    public synchronized void add1() {
        i++;
    }

    private Object obj = new Object();

    public void subtract() {

        synchronized (obj) {
            i--;
        }
    }
}
