package com.ly.base.array;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-11-30 10:53
 *  * @last modify by [luoyong 2019-11-30 10:53]
 * @Description: TwoDimensionalArrayTest 二维数组
 * 1.理解：
 * 对于二维数组的理解，我们可以看成是一维数组array1又作为另一个一维数组array2的元素而存在。
 * 其实，从数组底层的运行机制来看，其实没有多维数组。
 * <p>
 * 2. 二维数组的使用:
 * ① 二维数组的声明和初始化
 * ② 如何调用数组的指定位置的元素
 * ③ 如何获取数组的长度
 * ④ 如何遍历数组
 * ⑤ 数组元素的默认初始化值 :见 ArrayTest3.java
 * ⑥ 数组的内存解析 :见 ArrayTest3.java
 **/
public class TwoDimensionalArrayTest {
    public static void main(String[] args) {
        //1.二维数组的声明和初始化
        int[] arr = new int[]{1, 2, 3};//一维数组
        //静态初始化
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};
        //动态初始化1
        String[][] arr2 = new String[3][2];
        //动态初始化2
        String[][] arr3 = new String[3][];
        //错误的情况
//		String[][] arr4 = new String[][4];
//		String[4][3] arr5 = new String[][];
//		int[][] arr6 = new int[4][3]{{1,2,3},{4,5},{6,7,8}};

        //也是正确的写法：
        int[] arr4[] = new int[][]{{1, 2, 3}, {4, 5, 9, 10}, {6, 7, 8}};
        int[] arr5[] = {{1, 2, 3}, {4, 5}, {6, 7, 8}};

        //2.如何调用数组的指定位置的元素
        System.out.println(arr1[0][1]);//2
        System.out.println(arr2[1][1]);//null

        arr3[1] = new String[4];
        System.out.println(arr3[1][0]);

        //3.获取数组的长度
        //3
        System.out.println(arr4.length);
        //3
        System.out.println(arr4[0].length);
        //4
        System.out.println(arr4[1].length);

        //4.如何遍历二维数组
        for (int i = 0; i < arr4.length; i++) {

            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * @return void
     * @Description: 测试二维数组默认初始化值
     * 规定：二维数组分为外层数组的元素，内层数组的元素
     * int[][] arr = new int[4][3];
     * 外层元素：arr[0],arr[1]等
     * 内层元素：arr[0][0],arr[1][2]等
     * <p>
     * ⑤ 数组元素的默认初始化值
     * 针对于初始化方式一：比如：int[][] arr = new int[4][3];
     * 外层元素的初始化值为：地址值
     * 内层元素的初始化值为：与一维数组初始化情况相同
     * <p>
     * 针对于初始化方式二：比如：int[][] arr = new int[4][];
     * 外层元素的初始化值为：null
     * 内层元素的初始化值为：不能调用，否则报错。
     * @author luoyong
     * @create 11:01 2019-11-30
     * @last modify by [luoyong 11:01 2019-11-30 ]
     */
    @Test
    public void testDefaultValue() {
        int[][] arr = new int[4][3];
        //地址值--数组是引用类型-->[I@4c98385c
        System.out.println(arr[0]);
        //0
        System.out.println(arr[0][0]);
        //[[I@5fcfe4b2
        System.out.println(arr);
        System.out.println("*****************");
        float[][] arr1 = new float[4][3];
        System.out.println(arr1[0]);//地址值
        System.out.println(arr1[0][0]);//0.0

        System.out.println("*****************");

        String[][] arr2 = new String[4][2];
        System.out.println(arr2[1]);//地址值
        System.out.println(arr2[1][1]);//null

        System.out.println("*****************");
        double[][] arr3 = new double[4][];
        //null
        System.out.println(arr3[1]);
        //报错
//		System.out.println(arr3[1][0]);
    }
}
