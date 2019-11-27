package com.ly.base.thread.sync;

/**
 * @author luoyong
 * @Description: 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * 1.问题：卖票过程中，出现了重票、错票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时，其他
 * 线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。
 * 4.在Java中，我们通过同步机制，来解决线程的安全问题。
 * <p>
 * 方式一：同步代码块
 * synchronized(同步监视器){
 * //需要被同步的代码
 * <p>
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码。  -->不能包含代码多了，也不能包含代码少了。
 * 2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
 * 3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 * 要求：多个线程必须要共用同一把锁。
 * <p>
 * 补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 * 方式二：同步方法。
 * 如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 * <p>
 * <p>
 * 5.同步的方式，解决了线程的安全问题。---好处
 * 操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。 ---局限性
 * @create 2019-11-25 23:26
 * @last modify by [LuoYong 2019-11-25 23:26]
 **/
public class SellingTickets {
    public static void main(String[] args) {

        //有问题的窗口
//        testCommonWindow();
        //测试同步代码块
//        testSyncCodeBlock();

        //使用同步代码块解决继承Thread类的方式的线程安全问题
        testSyncCodeBlockForThread();
    }

    /**
     * @param
     * @return void
     * @Description: 有问题的窗口
     * @author luoyong
     * @create 22:51 2019/11/26
     * @last modify by [LuoYong 22:51 2019/11/26 ]
     */
    public static void testCommonWindow() {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * @param
     * @return void
     * @Description: 测试同步代码块
     * @author luoyong
     * @create 22:47 2019/11/26
     * @last modify by [LuoYong 22:47 2019/11/26 ]
     */
    public static void testSyncCodeBlock() {
        SyncCodeBlockWindow syncCodeBlockWindow = new SyncCodeBlockWindow();
        Thread t1 = new Thread(syncCodeBlockWindow);
        Thread t2 = new Thread(syncCodeBlockWindow);
        Thread t3 = new Thread(syncCodeBlockWindow);

        t1.setName("窗口4");
        t2.setName("窗口5");
        t3.setName("窗口6");

        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * @param
     * @return void
     * @Description: 使用同步代码块解决继承Thread类的方式的线程安全问题
     * @author luoyong
     * @create 23:03 2019/11/26
     * @last modify by [LuoYong 23:03 2019/11/26 ]
     */
    public static void testSyncCodeBlockForThread() {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口7");
        t2.setName("窗口8");
        t3.setName("窗口9");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Window implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {

                /**
                 *  增加了出错概率
                 */
                try {
                    //线程阻塞一下
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

/**
 * 同步代码块窗口
 * 操作共享数据的代码，即为需要被同步的代码
 * 共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 * 同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。(要求：多个线程必须要共用同一把锁。)
 * 同步的方式，解决了线程的安全问题。---好处
 * * 操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。 ---局限性
 */
class SyncCodeBlockWindow implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        //线程阻塞一下
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}

/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 */
class Window2 extends Thread {
    private static int ticket = 100;

    /**
     * 静态属性 随着类的加载而加载 多个对象共享一个obj
     */
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //synchronized (obj) {}
            //Class aClass=Window2.class; 类其实也是一个对象 这个对象是唯一的
            synchronized (Window2.class) {
                if (ticket > 0) {
                    try {
                        //线程阻塞一下
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 * 关于同步方法的总结：
 * 1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 * 2. 非静态的同步方法，同步监视器是：this
 * 静态的同步方法，同步监视器是：当前类本身
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sellTickets();
        }
    }

    /**
     * @param
     * @return void
     * @Description: 卖票 同步方法解决线程安全问题
     * @author luoyong
     * @create 22:57 2019/11/27
     * @last modify by [LuoYong 22:57 2019/11/27 ]
     */
    private synchronized void sellTickets() {
        //同步监视器：this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 */
class Window4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sellTickets();
        }
    }

    /**
     * @param
     * @return void
     * @Description: 卖票 同步方法解决线程安全问题
     * @author luoyong
     * @create 22:57 2019/11/27
     * @last modify by [LuoYong 22:57 2019/11/27 ]
     */
    private synchronized static void sellTickets() {
        //同步监视器：Window4.class
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

class Window4Test {
    public static void main(String[] args) {
        Thread t1 = new Window4();
        Thread t2 = new Window4();
        Thread t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

