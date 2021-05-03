package com.ly.senior.juc.rwlock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luoyong
 *  * @create 2021-05-02 11:31 下午
 *  * @last modify by [luoyong 2021-05-02 11:31 下午]
 * @Description: 锁降级
 * 锁降级：遵循获取写锁→再获取读锁→再释放写锁的次序，写锁能够降级成为读锁。
 * 如果一个线程占有了写锁，在不释放写锁的情况下，它还能占有读锁，即写锁降级为读锁。
 **/
public class LockDownGradingDemo {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();


    public static void main(String[] args) {

    }

    /**
     * @return void
     * @Description: 先写后读 锁降级
     * @author luoyong
     * @create 10:32 上午 2021/5/3
     * @last modify by [LuoYong 10:32 上午 2021/5/3 ]
     */
    @Test
    public void test1() {
        writeLock.lock();
        System.out.println("------111111");

        readLock.lock();
        System.out.println("------read");


        writeLock.unlock();
        readLock.unlock();
    }

    /**
     * @return void
     * @Description: 先读后写 阻塞 读的过程当中  如果锁没有释放 写线程不可以获得锁 必须读完之后 才有机会写
     * 如果有线程在读，那么写线程是无法获取写锁的，是悲观锁的策略
     * @author luoyong
     * @create 10:33 上午 2021/5/3
     * @last modify by [LuoYong 10:33 上午 2021/5/3 ]
     */
    @Test
    public void test2() {

        readLock.lock();
        System.out.println("------read");


        writeLock.lock();
        System.out.println("------111111");

        readLock.unlock();
        writeLock.unlock();

    }

    /**
     * @return void
     * @Description: 对test2的改进 只有这样写才不会一直阻塞
     * 在ReentrantReadWriteLock中，当读锁被使用时，如果有现成尝试获取写锁，该线程会被阻塞，所以，需要释放所有读锁，才可以获取写锁。
     * @author luoyong
     * @create 10:40 上午 2021/5/3
     * @last modify by [LuoYong 10:40 上午 2021/5/3 ]
     */
    @Test
    public void test3() {

        readLock.lock();
        System.out.println("------read");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        readLock.unlock();

        writeLock.lock();
        System.out.println("------111111");
        writeLock.unlock();

    }

    /**
     * @return void
     * @Description: 保证本次写之后 立刻能读 防止其他写线程将数据修改 简单来说没有读完 后续就不能再写了 保证本次版本的数据一致性
     * @author luoyong
     * @create 10:51 上午 2021/5/3
     * @last modify by [LuoYong 10:51 上午 2021/5/3 ]
     */
    @Test
    public void test4() {
        writeLock.lock();
        try {
            //biz 业务逻辑操作
            //本次写完立刻被读取。
            /*
             * 1
             * 2
             * 3
             * 4
             * 5----biz end
             * */
            readLock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }
}
