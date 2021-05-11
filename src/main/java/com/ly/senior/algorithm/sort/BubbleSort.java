package com.ly.senior.algorithm.sort;

import org.junit.Test;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author luoyong
 *  * @create 2020-05-04 11:07 上午
 *  * @last modify by [luoyong 2020-05-04 11:07 上午]
 * @Description: 冒泡排序
 **/
public class BubbleSort {
    public static void main(String[] args) {

    }

    /**
     * @return void
     * @Description: 测试实际运行时间
     * @author luoyong
     * @create 10:54 上午 2020/5/5
     * @last modify by [LuoYong 10:54 上午 2020/5/5 ]
     */
    @Test
    public void testTime() {
        int[] arr = new int[2];
        for (int i = 0; i < 2; i++) {
            arr[i] = (int) (Math.random() * 2); //生成一个[0, 8000000) 数
        }

        SecureRandom random = new SecureRandom();
        int i = random.nextInt(1);

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    /**
     * @param arr
     * @return void
     * @Description: 排序的封装
     * @author luoyong
     * @create 10:54 上午 2020/5/5
     * @last modify by [LuoYong 10:54 上午 2020/5/5 ]
     */
    private void bubbleSort(int arr[]) {
        int temp = 0;
        //是否进行交换标识
        boolean exchangeFlag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //进行了交换置为true
                    exchangeFlag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!exchangeFlag) {
                //没有进行数据的交换
                break;
            } else {
                //进行了交换 是否进行交换标识值置为false 进行下次判断
                exchangeFlag = false;
            }
        }
    }

    /**
     * @return void
     * @Description: 优化 在一趟排序中，一次交换都没有发生过 则提前结束排序
     * @author luoyong
     * @create 11:24 上午 2020/5/4
     * @last modify by [LuoYong 11:24 上午 2020/5/4 ]
     */
    @Test
    public void testAfterOptimization() {
        int[] array = new int[]{3, 9, -1, 10, 2};
        int temp = 0;
        //是否进行交换标识
        boolean exchangeFlag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //进行了交换置为true
                    exchangeFlag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序后的结果");
            System.out.println(Arrays.toString(array));
            if (!exchangeFlag) {
                //没有进行数据的交换
                break;
            } else {
                //进行了交换 是否进行交换标识值置为false 进行下次判断
                exchangeFlag = false;
            }
        }
    }

    /**
     * @return void
     * @Description: 测试优化后的写法
     * 冒泡排序 的时间复杂度 O(n^2) 双重for循环
     * @author luoyong
     * @create 11:19 上午 2020/5/4
     * @last modify by [LuoYong 11:19 上午 2020/5/4 ]
     */
    @Test
    public void testBubbleSort() {
        int[] array = new int[]{3, 9, -1, 10, -2};
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + i + 1 + "排序后的结果");
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * @return void
     * @Description: 测试冒泡排序思想
     * @author luoyong
     * @create 11:17 上午 2020/5/4
     * @last modify by [LuoYong 11:17 上午 2020/5/4 ]
     */
    @Test
    public void testBubbleSortThought() {

        int[] arr = new int[]{3, 11, -1, 10, -2};

        int temp = 0;

        // 第一趟排序，就是将第一大的数排在倒数第一位
        for (int j = 0; j < arr.length - 1; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第二趟排序，就是将第二大的数排在倒数第二位
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));


        // 第三趟排序，就是将第三大的数排在倒数第三位

        for (int j = 0; j < arr.length - 1 - 2; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第四趟排序，就是将第4大的数排在倒数第4位

        for (int j = 0; j < arr.length - 1 - 3; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));
    }
}
