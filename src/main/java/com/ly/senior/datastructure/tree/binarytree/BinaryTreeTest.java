package com.ly.senior.datastructure.tree.binarytree;

import com.ly.senior.datastructure.tree.common.HeroNode;
import org.junit.Test;

/**
 * @author luoyong
 * @Description: BinaryTreeTest
 * @create 2020-06-20 17:30
 * @last modify by [LuoYong 2020-06-20 17:30]
 **/
public class BinaryTreeTest {
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
     * @Description: 测试节点的删除
     * 规则：
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     * @author luoyong
     * @create 11:44 2020/6/21
     * @last modify by [LuoYong 11:44 2020/6/21 ]
     */
    @Test
    public void testDelNode() {
        initBinaryTree(binaryTree);
        //删除之前输出二叉树
        binaryTree.preOrder();
        binaryTree.delNode(5);
        //删除之后输出二叉树
        binaryTree.preOrder();
    }

    /**
     * @param
     * @return void
     * @Description: 测试前序遍历查找指定no对应的节点
     * @author luoyong
     * @create 10:35 2020/6/21
     * @last modify by [LuoYong 10:35 2020/6/21 ]
     */
    @Test
    public void testPreOrderSearch() {
        initBinaryTree(binaryTree);
        HeroNode heroNode = binaryTree.preOrderSearch(5);
        System.out.println(heroNode);
    }


    /**
     * @param
     * @return void
     * @Description: 测试中序遍历查找指定no对应的节点
     * @author luoyong
     * @create 10:35 2020/6/21
     * @last modify by [LuoYong 10:35 2020/6/21 ]
     */
    @Test
    public void testInfixOrderSearch() {
        initBinaryTree(binaryTree);
        HeroNode heroNode = binaryTree.infixOrderSearch(5);
        System.out.println(heroNode);
    }


    /**
     * @param
     * @return void
     * @Description: 测试后序遍历查找指定no对应的节点
     * @author luoyong
     * @create 10:35 2020/6/21
     * @last modify by [LuoYong 10:35 2020/6/21 ]
     */
    @Test
    public void testPostOrderSearch() {
        initBinaryTree(binaryTree);
        HeroNode heroNode = binaryTree.postOrderSearch(5);
        System.out.println(heroNode);
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
