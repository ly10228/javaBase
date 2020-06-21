package com.ly.senior.datastructure.tree.binarytree;

import lombok.Data;

/**
 * @author luoyong
 * @Description: 节点
 * @create 2020-06-20 17:07
 * @last modify by [LuoYong 2020-06-20 17:07]
 **/
@Data
public class HeroNode {
    private int no;
    private String name;
    /**
     * 左节点
     */
    private HeroNode left;

    /**
     * 右节点
     */
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * @param no
     * @return void
     * @Description: 删除指定编号的节点
     * 1：如果指定删除的节点是叶子节点 则直接删除该节点
     * 2：如果指定删除的节点非叶子节点 则删除该子树
     * 思路：
     * 1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
     * 2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
     * 3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
     * 4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
     * 5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.
     * @author luoyong
     * @create 11:08 2020/6/21
     * @last modify by [LuoYong 11:08 2020/6/21 ]
     */
    public void delNode(int no) {
        if (this.left != null && this.left.getNo() == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.getNo() == no) {
            this.right = null;
            return;
        }
        //向左递归
        if (this.left != null) {
            this.left.delNode(no);
        }
        //向右递归
        if (this.right != null) {
            this.right.delNode(no);
        }

    }

    /**
     * @param no 节点编号
     * @return
     * @Description: 前序遍历查找指定no对应的节点
     * @author luoyong
     * @create 10:19 2020/6/21
     * @last modify by [LuoYong 10:19 2020/6/21 ]
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        //父节点 比较当前结点是不是
        if (this.getNo() == no) {
            return this;
        }
        HeroNode resNode = null;
        //左子树遍历
        //判断当前节点的左节点是否为空 如果不为空 则递归前序查找
        //如果左递归前序查找，找到节点，则返回
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (null != resNode) {
            //左子树找到了
            return resNode;
        }
        //右子树遍历
        //当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * @param no 要查找的no
     * @return
     * @Description: 中序遍历查找指定no对应的节点
     * @author luoyong
     * @create 10:23 2020/6/21
     * @last modify by [LuoYong 10:23 2020/6/21 ]
     */
    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;
        //左子树遍历
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }
        System.out.println("进入中序遍历");
        //父节点
        if (this.getNo() == no) {
            return this;
        }

        //右子树遍历
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }


    /**
     * @param no 要查找的no
     * @return
     * @Description: 后序遍历查找指定no对应的节点
     * @author luoyong
     * @create 10:24 2020/6/21
     * @last modify by [LuoYong 10:24 2020/6/21 ]
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        //左子树遍历
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }
        //右子树遍历
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }
        System.out.println("进入后序遍历");
        //父节点
        if (this.getNo() == no) {
            return this;
        }
        return resNode;
    }

    /**
     * @param
     * @return void
     * @Description: 前序遍历
     * @author luoyong
     * @create 17:19 2020/6/20
     * @last modify by [LuoYong 17:19 2020/6/20 ]
     */
    public void preOrder() {
        //1:输出父节点
        System.out.println(this);
        //2:递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //3:递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * @param
     * @return void
     * @Description: 中序遍历
     * @author luoyong
     * @create 17:23 2020/6/20
     * @last modify by [LuoYong 17:23 2020/6/20 ]
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * @param
     * @return void
     * @Description: 后续遍历
     * @author luoyong
     * @create 17:25 2020/6/20
     * @last modify by [LuoYong 17:25 2020/6/20 ]
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


}
