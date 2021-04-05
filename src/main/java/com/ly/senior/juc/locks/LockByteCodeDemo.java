package com.ly.senior.juc.locks;

/**
 * @author luoyong
 *  * @create 2021-04-05 5:55 下午
 *  * @last modify by [luoyong 2021-04-05 5:55 下午]
 * @Description: 锁字节码演示
 **/
public class LockByteCodeDemo {
    final Object object = new Object();

    /**
     * @return void
     * @Description: 一个enter两个exit--》一定是这样的吗？
     * flags: ACC_PUBLIC
     * @author luoyong
     * @create 6:45 下午 2021/4/5
     * @last modify by [LuoYong 6:45 下午 2021/4/5 ]
     */
    public void m3() {
        synchronized (object) {
            System.out.println("----------hello sync");
        }
    }

    /**
     * @return void
     * @Description: （增加了异常）一个enter一个exit
     * flags: ACC_PUBLIC
     * @author luoyong
     * @create 6:46 下午 2021/4/5
     * @last modify by [LuoYong 6:46 下午 2021/4/5 ]
     */
    public void m1() {
        synchronized (object) {
            System.out.println("----------hello sync");
            throw new RuntimeException("----ex");
        }
    }

    /**
     * @return void
     * @Description: flags: ACC_PUBLIC, ACC_SYNCHRONIZED
     * @author luoyong
     * @create 7:11 下午 2021/4/5
     * @last modify by [LuoYong 7:11 下午 2021/4/5 ]
     */
    public synchronized void m2() {
        System.out.println("---hello synchronized method");
    }

    /**
     * @return void
     * @Description: flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     * @author luoyong
     * @create 7:11 下午 2021/4/5
     * @last modify by [LuoYong 7:11 下午 2021/4/5 ]
     */
    public static synchronized void m4() {

    }
}
