package com.ly.senior.datastructure.tree.avl;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2020-06-29 5:39 下午
 * <p>
 *  * @last modify by [luoyong 2020-06-29 5:39 下午]
 * @Description: 测试
 * int[] arr = {4,3,6,5,7,8}; 左旋
 * int[] arr = { 10, 12, 8, 9, 7, 6 }; 右旋
 * int[] arr = { 10, 11, 7, 6, 8, 9 };
 **/
public class AVLTreeTest {


    /**
     * @return
     * @Description: 初始化树
     * @author luoyong
     * @create 5:54 下午 2020/6/29
     * @last modify by [LuoYong 5:54 下午 2020/6/29 ]
     */
    private AVLTree initTree(int[] arr) {
        if (null == arr || arr.length < 1) {
            arr = new int[]{4, 3, 6, 5, 7, 8};
        }
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AvlNode(arr[i]));
        }
        return avlTree;
    }


    /**
     * @param
     * @return void
     * @Description: 测试双旋转
     * @author luoyong
     * @create 22:50 2020/7/1
     * @last modify by [LuoYong 22:50 2020/7/1 ]
     */
    @Test
    public void testDoubleRotate() {
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        AVLTree avlTree = initTree(arr);
        show(avlTree);
    }

    /**
     * @return void
     * @Description: 测试右旋
     * @author luoyong
     * @create 11:23 下午 2020/6/30
     * @last modify by [LuoYong 11:23 下午 2020/6/30 ]
     */
    @Test
    public void testRightRotate() {
        AVLTree avlTree = initTree(new int[]{10, 12, 8, 9, 7, 6});
        show(avlTree);
    }

    /**
     * @return void
     * @Description: 测试左旋
     * @author luoyong
     * @create 9:29 下午 2020/6/30
     * @last modify by [LuoYong 9:29 下午 2020/6/30 ]
     */
    @Test
    public void testLeftRotate() {
        AVLTree avlTree = initTree(null);
        show(avlTree);
    }

    /**
     * @param avlTree
     * @return void
     * @Description: 打印
     * @author luoyong
     * @create 9:32 下午 2020/6/30
     * @last modify by [LuoYong 9:32 下午 2020/6/30 ]
     */
    private void show(AVLTree avlTree) {
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
