package com.ly.senior.juc.atomics;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author luoyong
 *  * @create 2021-04-18 4:47 下午
 *  * @last modify by [luoyong 2021-04-18 4:47 下午]
 * @Description: LongAdder只能用来计算加法，且从零开始计算
 * LongAccumulator提供了自定义的函数操作
 **/
public class LongAdderAPIDemo {
    public static void main(String[] args) {
        //只能做加法
        LongAdder longAdder = new LongAdder();

        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.longValue());

        //第一种写法
//        LongAccumulator longAccumulator = new LongAccumulator(new LongBinaryOperator() {
//            @Override
//            public long applyAsLong(long left, long right) {
//                return left - right;
//            }
//        }, 100);

        //第二种写法 函数式变成 中间加减乘除自己可以定义
        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);

        //1
        longAccumulator.accumulate(1);
        //3
        longAccumulator.accumulate(2);
        //6
        longAccumulator.accumulate(3);

        System.out.println(longAccumulator.longValue());


    }
}
