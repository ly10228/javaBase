package com.ly.senior.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author luoyong
 *  * @create 2021-04-25 10:47 下午
 *  * @last modify by [luoyong 2021-04-25 10:47 下午]
 * @Description: 阻塞队列
 * ArrayBlockingQueue：是一个基于数组数据结构的阻塞队列，此队列按照FIFO(先进先出)原则对元素进行排序。
 * LinkedBlockingQueue：是一个基于链表的阻塞队列，此队列按照FIFO(先进先出)原则对元素进行排序，吞吐量通常要高于ArrayBlockingQueue
 * SynchronousQueue： 一个不存储元素的阻塞队列。每个插入操作必须等到另外一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于 LinkedBlockingQueue
 **/
public class BlockingQueueDemo {

    public final static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

    public static void main(String[] args) throws Exception {
        test4();
    }

    /**
     * @return void
     * @Description: 阻塞队列满时，队列会阻塞生产者线程指定的时间，超时后，生产者线程自动退出。
     * @author luoyong
     * @create 11:48 下午 2021/4/25
     * @last modify by [LuoYong 11:48 下午 2021/4/25 ]
     */
    public static void test4() throws InterruptedException {
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));
    }

    /**
     * @return void
     * @Description: 当阻塞队列满时，生产者线程继续往队列里面put元素，队列会一直阻塞生产线程直到put数据成功或响应中断退出
     * ​ 当阻塞队列空时，消费者线程视图从队列里面take元素，队列会一直阻塞消费者线程直到队列可用
     * @author luoyong
     * @create 11:45 下午 2021/4/25
     * @last modify by [LuoYong 11:45 下午 2021/4/25 ]
     */
    public static void test3() throws InterruptedException {
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        System.out.println("=====================================================>");
        blockingQueue.put("x");


        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }


    /**
     * @return void
     * @Description: 测试特殊值 插入方法，成功true，失败false ​ 移除方法，成功返回出队列的元素，队列里面没有就返回null
     * @author luoyong
     * @create 11:40 下午 2021/4/25
     * @last modify by [LuoYong 11:40 下午 2021/4/25 ]
     */
    public static void test2() {
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    /**
     * @return void
     * @Description: 抛出异常的api
     * 抛出异常：当阻塞队列满时，再往队列里面add()时，会抛出java.lang.IllegalStateException: Queue full
     * ​ 当阻塞队列空时，再去队列里面remove()时，会抛出java.util.NoSuchElementException
     * @author luoyong
     * @create 11:36 下午 2021/4/25
     * @last modify by [LuoYong 11:36 下午 2021/4/25 ]
     */
    public static void test1() {
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
    }
}
