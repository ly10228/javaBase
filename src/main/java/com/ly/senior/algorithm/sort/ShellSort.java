package com.ly.senior.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author luoyong
 *  * @create 2020-05-06 10:44 下午
 *  * @last modify by [luoyong 2020-05-06 10:44 下午]
 * @Description: ShellSort
 **/
public class ShellSort {

    int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

    /**
     * @return void
     * @Description: 希尔排序演变
     * @author luoyong
     * @create 10:50 下午 2020/5/6
     * @last modify by [LuoYong 10:50 下午 2020/5/6 ]
     */
    @Test
    public void testShellSortThought() {
        int temp = 0;

        //希尔排序的第1轮排序
        //10个数组分成5组
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    //进行交换
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));
        //第二轮交换
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    //进行交换
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮");
        System.out.println(Arrays.toString(arr));
        //第三轮交换
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    //进行交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @return void
     * @Description: 希尔排序封装
     * @author luoyong
     * @create 11:05 下午 2020/5/6
     * @last modify by [LuoYong 11:05 下午 2020/5/6 ]
     */
    private void shellSortExchange(int arr[]) {
        //数据值交换时 使用
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //分组
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * @return void
     * @Description: 测试希尔排序--封装
     * @author luoyong
     * @create 11:15 下午 2020/5/6
     * @last modify by [LuoYong 11:15 下午 2020/5/6 ]
     */
    @Test
    public void testShellSortExchange() {
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        shellSortExchange(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }


    /**
     * @param arr
     * @return void
     * @Description: 希尔排序--移位法
     * @author luoyong
     * @create 11:21 下午 2020/5/6
     * @last modify by [LuoYong 11:21 下午 2020/5/6 ]
     */
    private void shellSortShift(int arr[]) {
        //增量的gap 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //从第gap个元素起 逐步对其所在的组进行插入排序
                int insertIndex = i;
                int insertValue = arr[insertIndex];
                if (arr[insertIndex] < arr[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                        //移动
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[insertIndex] = insertValue;
                }
            }
        }
    }

    /**
     * @return void
     * @Description: 测试移位法
     * @author luoyong
     * @create 11:35 下午 2020/5/6
     * @last modify by [LuoYong 11:35 下午 2020/5/6 ]
     */
    @Test
    public void testShellSortShift() {
        System.out.println("排序前--移位法");
        System.out.println(Arrays.toString(arr));
        shellSortShift(arr);
        System.out.println("排序后--移位法");
        System.out.println(Arrays.toString(arr));
    }

}
