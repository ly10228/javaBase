package com.ly.senior.algorithm.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author luoyong
 *  * @create 2020-05-05 3:52 下午
 *  * @last modify by [luoyong 2020-05-05 3:52 下午]
 * @Description: 选择排序
 **/
public class SelectSort {

    /**
     * @return void
     * @Description: 选择排序的思想--从小到大
     * @author luoyong
     * @create 3:54 下午 2020/5/5
     * @last modify by [LuoYong 3:54 下午 2020/5/5 ]
     */
    @Test
    public void testBubbleSortThought() {
        int[] arr = new int[]{101, 34, 119, 1};
        //先假定最小值
        int minIndex = 0;
        int min = arr[0];
        //第一次循环  1, 34, 119,101
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                //min不是最小的数 进行交换
                //重置min和minIndex
                min = arr[i];
                minIndex = i;
            }
        }
        //将最小值 放在arr[0] 即交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));

        //第二轮 1, 34, 119, 101
        minIndex = 1;
        min = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (min > arr[i]) {
                //min不是最小的数 进行交换
                //重置min和minIndex
                min = arr[i];
                minIndex = i;
            }
        }
        //将最小值 放在arr[0] 即交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二轮");
        System.out.println(Arrays.toString(arr));

        //第三轮 1, 34, 101, 119
        minIndex = 2;
        min = arr[2];
        for (int i = 3; i < arr.length; i++) {
            if (min > arr[i]) {
                //min不是最小的数 进行交换
                //重置min和minIndex
                min = arr[i];
                minIndex = i;
            }
        }
        //将最小值 放在arr[0] 即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第三轮");
        System.out.println(Arrays.toString(arr));


    }

    /**
     * @return void
     * @Description: 测试排序时间
     * @author luoyong
     * @create 4:20 下午 2020/5/5
     * @last modify by [LuoYong 4:20 下午 2020/5/5 ]
     */
    @Test
    public void testSelectSortTime() {
        //创建一个大小为8万的数组 里面的内容随机
        int[] arr = new int[80000];
        //数组赋值
        for (int i = 0; i < arr.length; i++) {
            // 生成一个[0, 8000000) 数
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试选择排序
        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }


    @Test
    public void testSelectSort() {
        int[] arr = new int[]{101, 34, 119, 1};
        System.out.println("排序之前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序之后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @return void
     * @Description: 选择排序封装
     * @author luoyong
     * @create 4:18 下午 2020/5/5
     * @last modify by [LuoYong 4:18 下午 2020/5/5 ]
     */
    private void selectSort(int arr[]) {
        int minIndex = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            //先假定最小值
            minIndex = i;
            min = arr[i];
            for (int j = 1 + i; j < arr.length; j++) {
                if (min > arr[j]) {
                    //min不是最小值 重新设置最小值和最小值下标
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                //最小值的下标发生的变化 进行交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }


}
