package com.ly.senior.datastructure.tree.sequentialstoragebinarytree;

/**
 * @author luoyong
 * @Description: 顺序存储二叉树
 * 实际使用场景：八大排序算法当中的堆排序 就会使用到顺序存储二叉树
 * 基本概念
 * 从数据存储来看，数组存储方式和树的存储方式可以相互转换，即数组可以转换成树，树也可以转换成数组，
 *
 * @create 2020-06-21 16:44
 * @last modify by [LuoYong 2020-06-21 16:44]
 **/
public class ArrBinaryTree {
    /**
     * 存储数据节点的数组
     */
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * @param index 数组的下标
     * @return void
     * @Description: 完成顺序存储二叉树的前序遍历
     * @author luoyong
     * @create 16:46 2020/6/21
     * @last modify by [LuoYong 16:46 2020/6/21 ]
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder((index * 2 + 1));
        }
        //向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder((index * 2 + 2));
        }
    }
}
