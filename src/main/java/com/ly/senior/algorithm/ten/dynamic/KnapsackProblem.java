package com.ly.senior.algorithm.ten.dynamic;

/**
 * @author luoyong
 *  * @create 2020-07-12 11:00 上午
 *  * @last modify by [luoyong 2020-07-12 11:00 上午]
 * @Description: 动态规划
 **/
public class KnapsackProblem {

    /**
     * @return void
     * @Description: 动态规划
     * @author luoyong
     * @create 11:06 上午 2020/7/12
     * @last modify by [LuoYong 11:06 上午 2020/7/12 ]
     */
    public static void DynamicProgramming() {
        //物品的重量
        int[] w = {1, 4, 3};
        //物品的价值 这个val[i] 就是前面讲的v[i]
        int[] val = {1500, 3000, 2000};

        //背包的容量
        int m = 4;

        //物品的数量
        int n = val.length;

        //创建二维数组
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中最大的价值
        int[][] v = new int[n + 1][m + 1];

        //为了记录商品放入的情况
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {

        }

    }
}
