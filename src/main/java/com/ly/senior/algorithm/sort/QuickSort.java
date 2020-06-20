package com.ly.senior.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author luoyong
 * @Description: 快速排序
 * @create 2020-05-14 23:07
 * @last modify by [LuoYong 2020-05-14 23:07]
 **/
public class QuickSort {

    /**
     * @param
     * @return void
     * @Description: 测试快速排序
     * @author luoyong
     * @create 23:08 2020/5/14
     * @last modify by [LuoYong 23:08 2020/5/14 ]
     */
    @Test
    public void testQuickSort() {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        System.out.println("排序前=" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后=" + Arrays.toString(arr));
    }


    /**
     * @param arr
     * @param left
     * @param right
     * @return void
     * @Description: 快速排序算法实现
     * @author luoyong
     * @create 23:10 2020/5/14
     * @last modify by [LuoYong 23:10 2020/5/14 ]
     */
    private void quickSort(int[] arr, int left, int right) {
        //左下标
        int l = left;
        //右下标
        int r = right;
        //中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            //while循环的目的是让比pivot 值小的放到左边, 值大的放在右边
            while (arr[l] < pivot) {
                //在pivot左边一直找 找到大于等于pivot值 才退出
                l += 1;
            }
            while (arr[r] > pivot) {
                //在pivot右边一直找 找到小于等于pivot值  才退出
                r -= 1;
            }
            if (l >= r) {
                //说pivot的左右两边值 已经是 左边的都小于pivot 右边的都大于pivot
                break;
            }
            //进行数据交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换之后
            //如果arr[1]==pivot l++ 后移
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果arr[r]==pivot r-- 前移
            if (arr[r] == pivot) {
                l += 1;
            }

        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
