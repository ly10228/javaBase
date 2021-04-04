package com.ly.senior.juc.cf;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author luoyong
 *  * @create 2021-04-04 10:29 上午
 *  * @last modify by [luoyong 2021-04-04 10:29 上午]
 * @Description: 对Future的改进
 **/
public class CompletableFutureDemo {

    /**
     * public ThreadPoolExecutor(int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler)
     */
    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) throws ExecutionException, InterruptedException {
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


    /**
     * @return void
     * @Description: 测试get 阻塞
     * @author luoyong
     * @create 10:45 上午 2021/4/4
     * @last modify by [LuoYong 10:45 上午 2021/4/4 ]
     */
    @Test
    public void testGet() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----->come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return 3;
        });
        //会阻塞
        System.out.println(future3.get());

        System.out.println("------test over");
    }


    /**
     * @return void
     * @Description: testThenApply
     * @author luoyong
     * @create 10:53 上午 2021/4/4
     * @last modify by [LuoYong 10:53 上午 2021/4/4 ]
     */
    @Test
    public void testThenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return 3;
        }).thenApply(f -> {
            //第二个条件
            return f + 2;
        }).whenComplete((v, e) -> {
            //当执行完成
            if (e == null) {
                System.out.println("----result: " + v);
            }
        }).exceptionally(e -> {
            //执行出现异常
            e.printStackTrace();
            return null;
        });

        System.out.println("------testThenApply over");

        //主线程不要立刻结束 否则CompletableFuture默认使用的线程池会立刻关闭（可以暂停3s线程）
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }

}
