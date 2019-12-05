package com.ly.base.array.multidimensionalarrays;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author luoyong
 *  * @create 2019-11-30 11:55
 *  * @last modify by [luoyong 2019-11-30 11:55]
 * @Description: MultiDimensionalArraysExerTest 多维数组练习
 **/
public class MultiDimensionalArraysExerTest {

    String[] stringArr = new String[]{"JJ", "DD", "MM", "BB", "GG", "AA"};

    /**
     * @return void
     * @Description: 多维数组求和
     * @author luoyong
     * @create 11:56 2019-11-30
     * @last modify by [luoyong 11:56 2019-11-30 ]
     */
    @Test
    public void testSum() {
        //初始化一个数组
        int[][] arr = new int[][]{{3, 5, 8}, {12, 9}, {7, 0, 6, 4}};

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
                sum += arr[i][j];
            }
        }

        System.out.println("二维数组的总和是:" + sum);
    }

    /**
     * @return void
     * @Description: 打印杨辉三角
     * @author luoyong
     * @create 12:15 2019-11-30
     * @last modify by [luoyong 12:15 2019-11-30 ]
     */
    @Test
    public void testYangHui() {
        //二维数组定义
        int[][] arr = new int[10][];
        //数组赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];

            //给数组首尾赋值
            arr[i][0] = arr[i][i] = 1;

            if (i > 1) {
                for (int j = 1; j < arr[i].length - 1; j++) {
                    //给每行非首尾赋值
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


    /**
     * @return void
     * @Description:test1 算法的考查：求数值型数组中元素的最大值、最小值、平均数、总和等
     * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，
     * 然后求出所有元素的最大值，最小值，和值，平均值，并输出出来。
     * 要求：所有随机数都是两位数(Math.random() * (99 - 10 + 1) + 10)
     * @author luoyong
     * @create 12:59 2019-11-30
     * @last modify by [luoyong 12:59 2019-11-30 ]
     */
    @Test
    public void test1() {
        int[] arr = new int[10];
        //赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        //求数组元素的最大值
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        System.out.println("最大值为：" + maxValue);

        //求数组元素的最小值
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        System.out.println("最小值为：" + minValue);
        //求数组元素的总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("总和为：" + sum);
        //求数组元素的平均数
        int avgValue = sum / arr.length;
        System.out.println("平均数为：" + avgValue);
    }


    /**
     * @return void
     * @Description: 使用简单数组
     * (1)创建一个名为ArrayExer2的类，在main()方法中声明array1和array2两个变量，他们是int[]类型的数组。
     * (2)使用大括号{}，把array1初始化为8个素数：2,3,5,7,11,13,17,19。
     * (3)显示array1的内容。
     * (4)赋值array2变量等于array1，修改array2中的偶索引元素，使其等于索引值(如array[0]=0,array[2]=2)。打印出array1
     * arr1和arr2指向的是同一个地址值 也就是堆空间里面的同一个对象
     * @author luoyong
     * @create 13:17 2019-11-30
     * @last modify by [luoyong 13:17 2019-11-30 ]
     */
    @Test
    public void testCopyFalse() {
        int[] arr1, arr2;
        arr1 = new int[]{2, 3, 5, 7, 11, 13, 17, 19};

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }

        //arr1的地址值赋值给arr2
        //这个操作不能叫数据复制
        arr2 = arr1;
        //array2中的偶索引元素，使其等于索引值(如array[0]=0,array[2]=2)
        for (int j = 0; j < arr2.length; j++) {
            if (j % 2 == 0) {
                arr2[j] = j;
            }
        }
        System.out.println();
        //再输出arr1
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
    }


    /**
     * @return void
     * @Description: 测试数组赋值--正确
     * @author luoyong
     * @create 13:32 2019-11-30
     * @last modify by [luoyong 13:32 2019-11-30 ]
     */
    @Test
    public void testCopyTrue() {
        int[] array1, array2;

        array1 = new int[]{2, 3, 5, 7, 11, 13, 17, 19};

        //显示array1的内容
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }

        //数组的复制:
        array2 = new int[array1.length];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array1[i];
        }


        //修改array2中的偶索引元素，使其等于索引值(如array[0]=0,array[2]=2)
        for (int i = 0; i < array2.length; i++) {
            if (i % 2 == 0) {
                array2[i] = i;
            }

        }
        System.out.println();
        //打印出array1
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
    }


    /**
     * @return void
     * @Description: 数组反转
     * @author luoyong
     * @create 13:42 2019-11-30
     * @last modify by [luoyong 13:42 2019-11-30 ]
     */
    @Test
    public void testReverse() {
        //遍历
        Arrays.stream(stringArr).forEach(item -> {
            System.out.print(item + "\t");
        });

        //反转：方式一
//        for (int i = 0; i < stringArr.length / 2; i++) {
//            String temp = stringArr[i];
//            stringArr[i] = stringArr[stringArr.length - 1 - i];
//            stringArr[stringArr.length - 1 - i] = temp;
//        }

        //反转：方式二
        for (int i = 0, j = stringArr.length - 1; i < j; i++, j--) {
            String temp = stringArr[i];
            stringArr[i] = stringArr[j];
            stringArr[j] = temp;
        }
        System.out.println();
        //遍历
        Arrays.stream(stringArr).forEach(item -> {
            System.out.print(item + "\t");
        });
    }


    /**
     * @return void
     * @Description: 数组元素查找
     * @author luoyong
     * @create 13:57 2019-11-30
     * @last modify by [luoyong 13:57 2019-11-30 ]
     */
    @Test
    public void testQuery() {

        String dest = "BB";

        //是否查找到元素标识 默认false 没有查找到
        Boolean isFind = false;

        for (int i = 0; i < stringArr.length; i++) {
            String value = stringArr[i];
            if (StringUtils.isBlank(value)) {
                continue;
            }
            if (dest.equals(value)) {
                System.out.println("找到了目标元素，下标为:" + i);
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("未找到目标元素");
        }
    }

    /**
     * @return void
     * @Description: 二分查找
     * 前提：数组必须是有序的
     * @author luoyong
     * @create 14:09 2019-11-30
     * @last modify by [luoyong 14:09 2019-11-30 ]
     */
    @Test
    public void testBinarySearch() {
        int[] arr = new int[]{-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};

        int head = 0;
        int end = arr.length - 1;

        //默认没有查找到
        boolean isFind = false;

        //定义要被查找的目标元素
        int dest = 66;

        while (head <= end) {
            int mid = (head + end) / 2;
            if (arr[mid] == dest) {
                System.out.println("找到了目标元素,下标为:" + mid);
                isFind = true;
                break;
            } else if (dest > arr[mid]) {
                head = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (!isFind) {
            System.out.println("数组当中不存在目标元素");
        }
    }


    /**
     * @return void
     * @Description: 冒泡排序
     * 元素之间两两交换
     * @author luoyong
     * @create 14:45 2019-11-30
     * @last modify by [luoyong 14:45 2019-11-30 ]
     */
    @Test
    public void bubbleSort() {
        int[] arr = new int[]{43, 32, 76, -98, 0, 64, 33, -21, 32, 99};

        Arrays.stream(arr).forEach(item -> System.out.print(item + "\t"));

        //arr.length - 1循环的次数
        for (int i = 0; i < arr.length - 1; i++) {
            //比较次数 arr.length - 1 - i 例如第一次比较的是9次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = arr[j];
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序之后");
        Arrays.stream(arr).forEach(item -> System.out.print(item + "\t"));
    }


    /**
     * @return void
     * @Description: 快速排序
     * @author luoyong
     * @create 15:04 2019-11-30
     * @last modify by [luoyong 15:04 2019-11-30 ]
     */
    @Test
    public void QuickSort() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30};
        System.out.println("排序前:" + Arrays.toString(data));
        subSort(data, 0, data.length - 1);
        System.out.println("排序后:" + Arrays.toString(data));
    }


    /**
     * @param start
     * @param end
     * @return void
     * @Description: 快速排序算法
     * @author luoyong
     * @create 15:07 2019-11-30
     * @last modify by [luoyong 15:07 2019-11-30 ]
     */
    private void subSort(int[] data, int start, int end) {
        if (start < end) {
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true) {
                while (low < end && data[++low] - base <= 0) ;
                while (high > start && data[--high] - base >= 0) ;
                if (low < high) {
                    swap(data, low, high);
                } else {
                    break;
                }
            }
            swap(data, start, high);

            subSort(data, start, high - 1);//递归调用
            subSort(data, high + 1, end);
        }
    }

    /**
     * @param data
     * @param i
     * @param j
     * @return void
     * @Description: 数据位置交换
     * @author luoyong
     * @create 15:15 2019-11-30
     * @last modify by [luoyong 15:15 2019-11-30 ]
     */
    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
