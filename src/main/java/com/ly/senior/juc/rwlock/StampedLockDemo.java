package com.ly.senior.juc.rwlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author luoyong
 *  * @create 2021-05-03 4:50 下午
 *  * @last modify by [luoyong 2021-05-03 4:50 下午]
 * @Description: 票据锁
 **/
public class StampedLockDemo {
    static int number = 37;
    static StampedLock stampedLock = new StampedLock();

    public void write() {
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName() + "\t" + "=====写线程准备修改");
        try {
            number = number + 13;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stampedLock.unlockWrite(stamp);
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "=====写线程结束修改");
    }

    public void read() {
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName() + "\t come in readLock block,4 seconds continue...");
        //暂停线程4秒钟
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 正在读取中......");
        }

        try {
            int result = number;
            System.out.println(Thread.currentThread().getName() + "\t" + " 获得成员变量值result：" + result);
            System.out.println("写线程没有修改值，因为 stampedLock.readLock()读的时候，不可以写，读写互斥");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }


    /**
     * @return void
     * @Description: 乐观读
     * @author luoyong
     * @create 5:00 下午 2021/5/3
     * @last modify by [LuoYong 5:00 下午 2021/5/3 ]
     */
    public void tryOptimisticRead() {
        long stamp = stampedLock.tryOptimisticRead();
        int result = number;
        //间隔4秒钟，我们很乐观的认为没有其他线程修改过number值，愿望美好，实际情况靠判断。
        System.out.println("4秒前stampedLock.validate值(true无修改，false有修改)" + "\t" + stampedLock.validate(stamp));
        for (int i = 1; i <= 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 正在读取中......" + i +
                    "秒后stampedLock.validate值(true无修改，false有修改)" + "\t"
                    + stampedLock.validate(stamp));
        }

        if (!stampedLock.validate(stamp)) {
            System.out.println("有人动过--------存在写操作！");
            //有人动过了，需要从乐观读切换到普通读的模式。
            stamp = stampedLock.readLock();
            try {
                System.out.println("从乐观读 升级为 悲观读并重新获取数据");
                //重新获取数据
                result = number;
                System.out.println("重新悲观读锁通过获取到的成员变量值result：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t finally value: " + result);
    }


    public static void main(String[] args) {
        StampedLockDemo resource = new StampedLockDemo();

        //1 悲观读,和ReentrantReadWriteLock一样
        /*new Thread(() -> {
            //悲观读
            resource.read();
        },"readThread").start();*/

        //2 乐观读，成功
        /*new Thread(() -> {
            //乐观读
            resource.tryOptimisticRead();
        },"readThread").start();

        //6秒钟乐观读取resource.tryOptimisticRead()成功
        try { TimeUnit.SECONDS.sleep(6); } catch (InterruptedException e) { e.printStackTrace(); }*/

        //3 乐观读，失败，重新转为悲观读，重读数据一次
        new Thread(() -> {
            //乐观读
            resource.tryOptimisticRead();
        }, "readThread").start();

        //2秒钟乐观读取resource.tryOptimisticRead()失败
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            resource.write();
        }, "writeThread").start();
    }

}
