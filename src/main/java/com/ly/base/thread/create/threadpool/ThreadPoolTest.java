package com.ly.base.thread.create.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author luoyong
 *  * @create 2019-11-29 10:13
 *  * @last modify by [luoyong 2019-11-29 10:13]
 * @Description: 线程创建方式四: 线程池
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 * corePoolSize：核心池的大小
 * maximumPoolSize：最大线程数
 * keepAliveTime：线程没有任务时最多保持多长时间后会终止
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        //适用于Runnable
        service.execute(new NumberThread());
        service.execute(new NumberThread1());


        //service.submit(Callable callable);//适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }
}


class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
