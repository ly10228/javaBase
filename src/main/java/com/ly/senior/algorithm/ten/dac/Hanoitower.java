package com.ly.senior.algorithm.ten.dac;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2020-07-11 11:22 上午
 *  * @last modify by [luoyong 2020-07-11 11:22 上午]
 * @Description: 分治算法--实践--汉诺塔
 **/
public class Hanoitower {

    /**
     * @return void
     * @Description: 进行测试
     * @author luoyong
     * @create 7:10 下午 2020/7/11
     * @last modify by [LuoYong 7:10 下午 2020/7/11 ]
     */
    @Test
    public void test() {
        hanoiTower(10, 'A', 'B', 'C');
    }

    /**
     * @return void
     * @Description: 分治算法--实践--汉诺塔
     * @author luoyong
     * @create 11:23 上午 2020/7/11
     * @last modify by [LuoYong 11:23 上午 2020/7/11 ]
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果我们有n>=2情况 我们总是可以看做是两个盘 1:最下面是一个盘 2：上面所有的盘

            //1:先把最上面所有的盘 A->B 移动过程当中会使用到c
            hanoiTower(num - 1, a, c, b);

            //2:把最下面的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);


            //3:把B塔的所有的盘 从B->C 移动过程当中使用a塔
            hanoiTower(num - 1, b, a, c);


        }
    }
}
