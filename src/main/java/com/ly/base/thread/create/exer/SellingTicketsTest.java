package com.ly.base.thread.create.exer;

/**
 * @author luoyong
 * @Description: SellingTicketsTest--卖票
 * 存在线程的安全问题，待解决。
 * @create 2019-11-25 23:15
 * @last modify by [LuoYong 2019-11-25 23:15]
 **/
public class SellingTicketsTest {
    public static void main(String[] args) {
        SellingTicketsThread s1 = new SellingTicketsThread("窗口1");
        SellingTicketsThread s2 = new SellingTicketsThread("窗口2");
        SellingTicketsThread s3 = new SellingTicketsThread("窗口3");

        s1.start();
        s2.start();
        s3.start();
    }
}


class SellingTicketsThread extends Thread {

    /**
     * 100张票
     */
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + "卖票,票号为:" + ticket);
                ticket--;
            } else {
                System.out.println("票已经卖完了");
                break;
            }
        }

    }

    public SellingTicketsThread(String name) {
        super(name);
    }
}


