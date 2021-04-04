package com.ly.senior.juc.cf;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author luoyong
 *  * @create 2021-04-04 12:27 上午
 *  * @last modify by [luoyong 2021-04-04 12:27 上午]
 * @Description: FutureTask
 * FutureTask 缺点：get()阻塞
 * 什么是高并发--》克服阻塞 尽量少加锁或者不加锁
 * 不见不散--过时不候--轮询（以下都不建议使用）
 **/
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " ---->come in");
            try {
                //睡眠5s
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return 1024;
        });

        //启动线程
        new Thread(futureTask, "t1").start();


        //不见不散 只要出现get方法，不管是否计算完成都阻塞等待结果出来再运行 一定要放在程序的最末端
//        System.out.println(futureTask.get());
        //过时不候 推荐使用这种
//        System.out.println(futureTask.get(2L, TimeUnit.SECONDS));

        //不要阻塞 尽量用轮询替代
        while (true) {
            if (futureTask.isDone()) {
                System.out.println("----result:" + futureTask.get());
                break;
            } else {
                System.out.println("还是计算当中----》请稍后");
            }
        }

        System.out.println("----->主线程继续执行");

    }
}
