package com.ly.senior.juc.cf;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author luoyong
 *  * @create 2021-04-05 12:02 下午
 *  * @last modify by [luoyong 2021-04-05 12:02 下午]
 * @Description: CompletableFutureApi演示
 **/
public class CompletableFutureAPIDemo {


    /**
     * 线程池
     */
    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(50),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5000; i++) {
                CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    try {
                        //睡眠2s
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1;
                }, threadPoolExecutor);
            }
        } catch (Exception ex) {
            System.out.println("捕获到异常信息");
            System.out.println(ex.getMessage());
        }

    }

    /**
     * @return void
     * @Description: 以下四种api测试
     * get() 不见不散
     * get(2, TimeUnit.SECONDS) 过时不候
     * future.getNow(9999)
     * public boolean complete(T value)
     * @author luoyong
     * @create 3:52 下午 2021/4/5
     * @last modify by [LuoYong 3:52 下午 2021/4/5 ]
     */
    @Test
    public void testM1() throws InterruptedException, ExecutionException, TimeoutException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                //睡眠2s
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }, threadPoolExecutor);

        //不见不散 直接阻塞
//        System.out.println(future.get());

        //过时不候 设置等待超时时间
//        System.out.println(future.get(2, TimeUnit.SECONDS));

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        //立即获取 如果没有拿到结果就返回9999
//        System.out.println(future.getNow(9999));

        //public boolean complete(T value) 如果返回false 拿到的就是真正的结果 返回的true代表阻断成功 拿到的值是44
        System.out.println(future.complete(-44) + "\t" + future.get());
        threadPoolExecutor.shutdown();
    }

    /**
     * @return void
     * @Description: 测试 对计算结果进行处理
     * thenApply
     * 计算结果存在依赖关系，这两个线程串行化
     * 由于存在依赖关系(当前步错，不走下一步)，当前步骤有异常的话就叫停。
     * handle
     * 有异常也可以往下一步走，根据带的异常参数可以进一步处理
     * @author luoyong
     * @create 4:15 下午 2021/4/5
     * @last modify by [LuoYong 4:15 下午 2021/4/5 ]
     */
    @Test
    public void testM2() {

        System.out.println(CompletableFuture.supplyAsync(() -> {
            return 1;
        }).handle((f, e) -> {
            System.out.println("-------->1");
            //制造异常 后续无法进行
            int i = 10 / 0;
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("-------->2");
            return f + 3;
        }).handle((f, e) -> {
            System.out.println("-------->3");
            return f + 4;
        }).whenComplete((f, e) -> {
            if (null == e) {
                System.out.println("result=====" + f);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join());


        System.out.println(CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            System.out.println("-------->1");
            //制造异常 后续无法进行
            int i = 10 / 0;
            return f + 2;
        }).thenApply(f -> {
            System.out.println("-------->2");
            return f + 3;
        }).thenApply(f -> {
            System.out.println("-------->3");
            return f + 4;
        }).whenComplete((f, e) -> {
            if (null == e) {
                System.out.println("result=====" + f);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join());
    }


    /**
     * @return void
     * @Description: 对计算结果进行消费
     * @author luoyong
     * @create 4:33 下午 2021/4/5
     * @last modify by [LuoYong 4:33 下午 2021/4/5 ]
     */
    @Test
    public void testM3() {
        CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 2;
        }).thenApply(f -> {
            return f + 3;
        }).thenAccept(r -> System.out.println(r));

        //补充 任务之间执行顺序的说明

        //任务 A 执行完执行 B，并且 B 不需要 A 的结果
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {
        }).join());

        //任务 A 执行完执行 B，B 需要 A 的结果，但是任务 B 无返回值
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(resultA -> {
        }).join());

        //任务 A 执行完执行 B，B 需要 A 的结果，同时任务 B 有返回值
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(resultA -> resultA + " resultB").join());
    }


    /**
     * @return void
     * @Description: 对计算速度进行选用 类似于斗地主游戏的场景
     * @author luoyong
     * @create 4:44 下午 2021/4/5
     * @last modify by [LuoYong 4:44 下午 2021/4/5 ]
     */
    @Test
    public void testM4() {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }), r -> {
            return r;
        }).join());

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Description: 对计算结果进行合并 案例（一个报表 涉及到多个模块 比如 商机信息+合同信息 分别起两个线程去计算 然后进行合并）
     * 两个CompletionStage任务都完成后，最终能把两个任务的结果一起交给thenCombine 来处理
     * 先完成的先等着，等待其它分支任务
     * @author luoyong
     * @create 4:52 下午 2021/4/5
     * @last modify by [LuoYong 4:52 下午 2021/4/5 ]
     */
    public void testM5() {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            return 20;
        }), (r1, r2) -> {
            return r1 + r2;
        }).join());
    }
}
