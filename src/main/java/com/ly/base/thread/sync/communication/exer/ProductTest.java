package com.ly.base.thread.sync.communication.exer;

/**
 * @author luoyong
 *  * @create 2019-11-28 21:07
 *  * @last modify by [luoyong 2019-11-28 21:07]
 * @Description: ProductTest
 * 线程通信的应用：经典例题：生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程的安全问题？同步机制,有三种方法
 * 4. 是否涉及线程的通信？是
 **/
public class ProductTest {

    public static void main(String[] args) {
        //创建客户和生产者两个线程
        Clerk clerk = new Clerk();

        //生产者
        Producer producer = new Producer(clerk);

        //消费者
        Customer customer = new Customer(clerk);

        Thread t1 = new Thread(producer);

        Thread t2 = new Thread(customer);

        t1.setName("生产者");
        t2.setName("消费者");

        t1.start();
        t2.start();


    }
}

class Clerk {

    private int productCount = 0;

    /**
     * @return void
     * @Description: 生产产品
     * @author luoyong
     * @create 21:22 2019-11-28
     * @last modify by [luoyong 21:22 2019-11-28 ]
     */
    public synchronized void produceProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @return void
     * @Description: 消费产品
     * @author luoyong
     * @create 08:21 2019-11-29
     * @last modify by [luoyong 08:21 2019-11-29 ]
     */
    public synchronized void consumerProducts() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}


/**
 * 生产者--生产产品
 */
class Producer implements Runnable {


    /**
     * 聚合店员
     */
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品.....");

        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

/**
 * 消费者--消费产品
 */
class Customer implements Runnable {

    /**
     * 聚合店员
     */
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        //消费者消费产品
        System.out.println(Thread.currentThread().getName() + ":开始消费产品.....");

        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerProducts();
        }
    }
}