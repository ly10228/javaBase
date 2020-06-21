package com.ly.senior.datastructure.tree.sequentialstoragebinarytree;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: ArrBinaryTreeTest
 * @create 2020-06-21 16:50
 * @last modify by [LuoYong 2020-06-21 16:50]
 **/
public class ArrBinaryTreeTest {

    /**
     * @param
     * @return void
     * @Description: 测试ArrayBinaryTree, 实现顺序存储二叉树遍历
     * @author luoyong
     * @create 16:52 2020/6/21
     * @last modify by [LuoYong 16:52 2020/6/21 ]
     */
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
