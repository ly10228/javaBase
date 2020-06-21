package com.ly.senior.datastructure.tree.binarytree;

/**
 * @author luoyong
 * @Description: BinaryTree
 * @create 2020-06-20 17:28
 * @last modify by [LuoYong 2020-06-20 17:28]
 **/
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    /**
     * @param no 指定编号
     * @return void
     * @Description: 前序遍历 查找指定no对应的节点
     * @author luoyong
     * @create 10:33 2020/6/21
     * @last modify by [LuoYong 10:33 2020/6/21 ]
     */
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }


    /**
     * @param no 指定编号
     * @return void
     * @Description: 中序遍历 查找指定no对应的节点
     * @author luoyong
     * @create 10:33 2020/6/21
     * @last modify by [LuoYong 10:33 2020/6/21 ]
     */
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * @param no 指定编号
     * @return void
     * @Description: 后序遍历 查找指定no对应的节点
     * @author luoyong
     * @create 10:33 2020/6/21
     * @last modify by [LuoYong 10:33 2020/6/21 ]
     */
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }


    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}
