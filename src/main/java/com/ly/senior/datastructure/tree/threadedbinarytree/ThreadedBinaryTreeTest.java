package com.ly.senior.datastructure.tree.threadedbinarytree;

import com.ly.senior.datastructure.tree.common.HeroNode;
import org.junit.Test;

/**
 * @author luoyong
 * @Description: 线索化二叉树测试
 * @create 2020-06-21 17:53
 * @last modify by [LuoYong 2020-06-21 17:53]
 **/
public class ThreadedBinaryTreeTest {


    /**
     * @param
     * @return void
     * @Description: 线索化二叉树测试
     * @author luoyong
     * @create 17:53 2020/6/21
     * @last modify by [LuoYong 17:53 2020/6/21 ]
     */
    @Test
    public void test() {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        //3
        System.out.println("10号结点的前驱结点是 =" + leftNode);
        //1
        System.out.println("10号结点的后继结点是=" + rightNode);

        //当线索化二叉树后，能在使用原来的遍历方法
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        // 8, 3, 10, 1, 14, 6
        threadedBinaryTree.threadedList();
    }
}
