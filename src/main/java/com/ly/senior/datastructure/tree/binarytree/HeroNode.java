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
