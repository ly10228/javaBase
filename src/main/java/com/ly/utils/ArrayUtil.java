package com.ly.utils;

/**
 * @author luoyong
 * @Description: 自定义数组的工具类
 * @create 2019-09-26 22:49
 * @last modify by [LuoYong 2019-09-26 22:49]
 **/
public class ArrayUtil {
    /**
     * @param arr
     * @return int
     * @Description: 求数组的最大值
     * @author luoyong
     * @create 22:51 2019/9/26
     * @last modify by [LuoYong 22:51 2019/9/26 ]
     */
    public int getMax(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    /**
     * @param arr
     * @return int
     * @Description: 求数组的最小值
     * @author luoyong
     * @create 22:51 2019/9/26
     * @last modify by [LuoYong 22:51 2019/9/26 ]
     */
    public int getMin(int[] arr) {
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        return minValue;
    }

    /**
     * @param arr
     * @return int
     * @Description: 求数组的总和
     * @author luoyong
     * @create 22:51 2019/9/26
     * @last modify by [LuoYong 22:51 2019/9/26 ]
     */
    public int getSum(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * @param arr
     * @return int
     * @Description: 求数组的平均值
     * @author luoyong
     * @create 22:50 2019/9/26
     * @last modify by [LuoYong 22:50 2019/9/26 ]
     */
    public int getAvg(int[] arr) {

        return getSum(arr) / arr.length;
    }


    /**
     * @param arr
     * @return void
     * @Description: 如下的两个同名方法构成了重载
     * 反转数组
     * @author luoyong
     * @create 22:50 2019/9/26
     * @last modify by [LuoYong 22:50 2019/9/26 ]
     */
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public void reverse(String[] arr) {

    }

    /**
     * @param arr
     * @return int[]
     * @Description: 复制数组
     * @author luoyong
     * @create 22:50 2019/9/26
     * @last modify by [LuoYong 22:50 2019/9/26 ]
     */
    public int[] copy(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }


    /**
     * @param arr
     * @return void
     * @Description: 数组排序
     * @author luoyong
     * @create 22:50 2019/9/26
     * @last modify by [LuoYong 22:50 2019/9/26 ]
     */
    public void sort(int[] arr) {
        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
                    //错误的：
//					swap(arr[j],arr[j + 1]);
                    //正确的：
                    swap(arr, j, j + 1);
                }

            }

        }
    }

    //错误的：交换数组中指定两个位置元素的值
//	public void swap(int i,int j){
//		int temp = i;
//		i = j;
//		j = temp;
//	}
    //正确的：交换数组中指定两个位置元素的值
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * @param arr
     * @return void
     * @Description: 遍历数组
     * @author luoyong
     * @create 22:49 2019/9/26
     * @last modify by [LuoYong 22:49 2019/9/26 ]
     */
    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * @param arr
     * @param dest
     * @return int
     * @Description: 查找指定元素
     * @author luoyong
     * @create 22:49 2019/9/26
     * @last modify by [LuoYong 22:49 2019/9/26 ]
     */
    public int getIndex(int[] arr, int dest) {
        // 线性查找：

        for (int i = 0; i < arr.length; i++) {

            if (dest == arr[i]) {
                return i;
            }

        }
        //返回一个负数，表示没有找到
        return -1;
    }
}
