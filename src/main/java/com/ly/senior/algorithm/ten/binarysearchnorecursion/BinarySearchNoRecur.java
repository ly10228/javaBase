package com.ly.senior.algorithm.ten.binarysearchnorecursion;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2020-07-10 5:55 下午
 *  * @last modify by [luoyong 2020-07-10 5:55 下午]
 * @Description: 二分查找--非递归版本
 **/
public class BinarySearchNoRecur {

    /**
     * @return void
     * @Description: 测试二分查找--非递归
     * @author luoyong
     * @create 11:15 上午 2020/7/11
     * @last modify by [LuoYong 11:15 上午 2020/7/11 ]
     */
    @Test
    public void test() {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);
    }

    /**
     * @param arr    待查找的数组 arr是一个有序的数组 这边默认是升序
     * @param target 要查找的值
     * @return int
     * @Description: 返回要
     * @author luoyong
     * @create 5:57 下午 2020/7/10
     * @last modify by [LuoYong 5:57 下午 2020/7/10 ]
     */
    public static int binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                //左边
                right -= 1;
            } else if (arr[mid] > target) {
                //右边
                left -= 1;

            }
        }
        return -1;
    }
}
