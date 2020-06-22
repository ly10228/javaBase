package com.ly.senior.algorithm.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author luoyong
 *  * @create 2020-05-20 9:39 下午
 *  * @last modify by [luoyong 2020-05-20 9:39 下午]
 * @Description: 归并排序
 **/
public class MergeSort {

    /**
     * @return void
     * @Description: 测试归并排序速度
     * @author luoyong
     * @create 8:45 下午 2020/5/25
     * @last modify by [LuoYong 8:45 下午 2020/5/25 ]
     */
    @Test
    public void testMergeSortSpeed() {
        int arr[] = new int[80000];
        //数组赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.random() * 8000000;
        }
        //测试速度
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //归并排序需要一个额外空间
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    /**
     * @return void
     * @Description: 测试归并排序
     * @author luoyong
     * @create 8:50 下午 2020/5/25
     * @last modify by [LuoYong 8:50 下午 2020/5/25 ]
     */
    @Test
    public void testMergeSort() {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        //归并排序需要一个额外空间
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @param temp
     * @return void
     * @Description: 分+合方法
     * @author luoyong
     * @create 8:40 下午 2020/5/25
     * @last modify by [LuoYong 8:40 下午 2020/5/25 ]
     */
    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            //中间索引
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr, left, mid, temp);
            //向右递归
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     * @return void
     * @Description: 合并方法
     * @author luoyong
     * @create 9:44 下午 2020/5/20
     * @last modify by [LuoYong 9:44 下午 2020/5/20 ]
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //初始化i 左边有序序列的初始索引
        int i = left;
        //初始化j 右边有序序列的初始索引值
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;
        //1:先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //将左边的元素填充到temp数组
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            } else {
                //反之
                //右边的大于左边的元素 右边的元素填充到数组当中
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }

        //2:把剩余数组的一边数据依次全部填充到temp
        while (i <= mid) {
            //左边的有序序列还有剩余元素 就全部填充到temp
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right) {
            //右边的有序序列还有剩余元素 就全部填充到temp
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }

        //3: 将temp数组的元素都拷贝到arr 不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
