package com.ly.senior.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luoyong
 *  * @create 2021-04-11 10:02 下午
 *  * @last modify by [luoyong 2021-04-11 10:02 下午]
 * @Description: CASDemo
 **/
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.get());


        System.out.println(atomicInteger.compareAndSet(5, 308) + "\t" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 3333) + "\t" + atomicInteger.get());
    }
}
