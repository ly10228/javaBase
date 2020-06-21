package com.ly.senior.datastructure.tree.binarytree;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: BinaryTreeDemo
 * @create 2020-06-20 17:30
 * @last modify by [LuoYong 2020-06-20 17:30]
 **/
public class BinaryTreeDemo {
    private BinaryTree binaryTree = new BinaryTree();

    private BinaryTree initBinaryTree(BinaryTree binaryTree) {
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //说明，我们先手动创建该二叉树，后面我们用递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        return binaryTree;
    }

    /**
     * @param
     * @return void
     * @Description: 测试前序遍历
     * root-->左子-->右子
     * @author luoyong
     * @create 17:32 2020/6/20
     * @last modify by [LuoYong 17:32 2020/6/20 ]
     */
    @Test
    public void testPreOrder() {
        initBinaryTree(binaryTree);
        //输出结果1 2 3 5 4
        binaryTree.preOrder();
    }

    /**
     * @param
     * @return void
     * @Description: 测试中序遍历
     * @author luoyong
     * @create 17:35 2020/6/20
     * @last modify by [LuoYong 17:35 2020/6/20 ]
     */
    @Test
    public void testInfixOrder() {
        initBinaryTree(binaryTree);
        ///输出结果2 1 5 3 4
        binaryTree.infixOrder();
    }

    /**
     * @param
     * @return void
     * @Description: 测试后续遍历
     * @author luoyong
     * @create 17:38 2020/6/20
     * @last modify by [LuoYong 17:38 2020/6/20 ]
     */
    @Test
    public void testPostOrder() {
        initBinaryTree(binaryTree);
        ///输出结果2 5 4 3 1
        binaryTree.postOrder();
    }
}
