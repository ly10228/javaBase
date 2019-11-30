package com.ly.base.array.multidimensionalarrays;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-11-30 11:55
 *  * @last modify by [luoyong 2019-11-30 11:55]
 * @Description: MultiDimensionalArraysExerTest 多维数组练习
 **/
public class MultiDimensionalArraysExerTest {


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
}
