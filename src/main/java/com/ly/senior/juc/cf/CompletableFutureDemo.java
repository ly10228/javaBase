package com.ly.senior.juc.cf;

import java.util.concurrent.*;

/**
 * @author luoyong
 *  * @create 2021-04-04 10:29 上午
 *  * @last modify by [luoyong 2021-04-04 10:29 上午]
 * @Description: 对Future的改进
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         *     public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler)
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            //ForkJoinPool.commonPool-worker-1----->come in
            System.out.println(Thread.currentThread().getName() + "----->come in");
        });

        //null
        System.out.println(future1.get());

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            //pool-1-thread-1----->come in
            System.out.println(Thread.currentThread().getName() + "----->come in");
        }, threadPoolExecutor);
        //null
        System.out.println(future2.get());

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----->come in");
            return 3;
        });
        System.out.println(future3.get());

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----->come in");
            return 4;
        }, threadPoolExecutor);
        System.out.println(future4.get());

        threadPoolExecutor.shutdown();
    }
}
