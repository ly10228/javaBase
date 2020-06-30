package com.ly.senior.datastructure.tree.avl;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2020-06-29 5:39 下午
 *  * @last modify by [luoyong 2020-06-29 5:39 下午]
 * @Description: 测试
 **/
public class AVLTreeTest {


    /**
     * @return
     * @Description: 初始化树
     * @author luoyong
     * @create 5:54 下午 2020/6/29
     * @last modify by [LuoYong 5:54 下午 2020/6/29 ]
     */
    private AVLTree initTree() {
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AvlNode(arr[i]));
        }
        return avlTree;
    }


    /**
     * @return void
     * @Description: 测试获取树的高度
     * @author luoyong
     * @create 5:52 下午 2020/6/29
     * @last modify by [LuoYong 5:52 下午 2020/6/29 ]
     */
    @Test
    public void testTreeHeight() {
        AVLTree avlTree = initTree();
        //4
        System.out.println("树的高度=" + avlTree.getRoot().height());
        // 3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight());
        // 1
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight());
        //8
        System.out.println("当前的根结点=" + avlTree.getRoot());
    }
}