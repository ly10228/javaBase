package com.ly.senior.algorithm.sort;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2020-05-25 8:53 下午
 *  * @last modify by [luoyong 2020-05-25 8:53 下午]
 * @Description: 基数排序 典型的空间换时间的排序算法
 **/
public class RadixSort {
    int arr[] = {53, 3, 542, 748, 14, 214};


    /**
     * @return void
     * @Description: 基础排序演变流程
     * @author luoyong
     * @create 8:55 下午 2020/5/25
     * @last modify by [LuoYong 8:55 下午 2020/5/25 ]
     */
    @Test
    public void testRadixSortProcess() {
        //定义一个二维数组 表示10个桶 每个桶就是一个一维数组
        //二维数组包含了10个一维数组
        //为了防止在放入数据的时候 数组溢出 则每个一维数组(桶)，大小定为arr.lengt
        //基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
    }
}
