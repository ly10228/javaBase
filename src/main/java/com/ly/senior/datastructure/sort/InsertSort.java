package com.ly.senior.datastructure.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author luoyong
 *  * @create 2020-05-05 4:43 下午
 *  * @last modify by [luoyong 2020-05-05 4:43 下午]
 * @Description: 插入排序
 **/
public class InsertSort {

    /**
     * @return void
     * @Description: 插入排序思想
     * @author luoyong
     * @create 4:43 下午 2020/5/5
     * @last modify by [LuoYong 4:43 下午 2020/5/5 ]
     */
    @Test
    public void testInsertSortThought() {
        int arr[] = new int[]{101, 34, 119, 1};

        //第一轮
        //定义要插入的元素
        int insertValue = arr[1];
        //要比较的位置下标
        int insertIndex = 1 - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            //还没有找到合适的位置
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));


        //第二轮
        //定义要插入的元素
        insertValue = arr[2];
        //要比较的位置下标
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            //还没有找到合适的位置
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第二轮");
        System.out.println(Arrays.toString(arr));


        //第3轮
        //定义要插入的元素
        insertValue = arr[3];
        //要比较的位置下标
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            //还没有找到合适的位置
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第三轮");
        System.out.println(Arrays.toString(arr));

    }


    /**
     * @return void
     * @Description: 测试插入排序
     * @author luoyong
     * @create 4:58 下午 2020/5/5
     * @last modify by [LuoYong 4:58 下午 2020/5/5 ]
     */
    @Test
    public void testInsertSort() {
        int arr[] = new int[]{101, 34, 119, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @return void
     * @Description: 插入排序封装
     * @author luoyong
     * @create 4:53 下午 2020/5/5
     * @last modify by [LuoYong 4:53 下午 2020/5/5 ]
     */
    private void insertSort(int arr[]) {
        //定义要插入的元素值
        int insertValue = 0;
        //插入要先比较的位置 跟前一个位置的元素做比较
        int insertDiffIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //定义要插入的元素值
            insertValue = arr[i];
            //插入要先比较的位置 跟前一个位置的元素做比较
            insertDiffIndex = i - 1;
            while (insertDiffIndex >= 0 && insertValue < arr[insertDiffIndex]) {
                //还没有找到合适的位置
                arr[insertDiffIndex + 1] = arr[insertDiffIndex];
                insertDiffIndex--;
            }
            if (insertDiffIndex + 1 != i) {
                //不是原来的位置
                arr[insertDiffIndex + 1] = insertValue;
            }

        }
    }

    /**
     * @return void
     * @Description: 测试执行时间
     * @author luoyong
     * @create 5:00 下午 2020/5/5
     * @last modify by [LuoYong 5:00 下午 2020/5/5 ]
     */
    @Test
    public void testInsertSortTime() {
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试插入排序
        insertSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }
}
