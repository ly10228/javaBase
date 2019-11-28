package com.ly.base.thread.sync.communication;

/**
 * @author luoyong
 *  * @create 2019-11-28 20:10
 *  * @last modify by [luoyong 2019-11-28 20:10]
 * @Description: CommunicationTest 线程通信
 * 线程通信的例子：使用两个线程打印 1-100。线程1, 线程2 交替打印
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 * 否则，会出现IllegalMonitorStateException异常
 * 3.wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中。
 * 面试题：sleep() 和 wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep() , Object类中声明wait()
 * 2）调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
 * 3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 **/
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");
        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();

    }
}

class Number implements Runnable {

    private int number = 1;

    private Object object = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (this) {
            synchronized (object) {

                //下一次线程进来唤醒被阻塞的线程
//                this.notify();
                object.notify();

                if (number <= 100) {

                    //休眠100ms便于观察
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //当前线程阻塞并释放锁
//                        this.wait();
                        object.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }


                } else {
                    break;
                }
            }

        }
    }
}