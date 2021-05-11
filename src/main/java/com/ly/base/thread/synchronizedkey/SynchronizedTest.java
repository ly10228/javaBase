package com.ly.base.thread.synchronizedkey;

/**
 * @author luoyong
 *  * @create 2021-03-16 5:42 下午
 *  * @last modify by [luoyong 2021-03-16 5:42 下午]
 * @Description: SynchronizedTest
 **/
public class SynchronizedTest {
    private static Object object = new Object();

    public static void main(String[] args) throws Exception {
        synchronized (object) {

        }
    }

    public static synchronized void m() {
    }
}
