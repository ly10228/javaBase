package com.ly.senior.datastructure.tree.binarysorttree;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2020-06-27 5:53 下午
 *  * @last modify by [luoyong 2020-06-27 5:53 下午]
 * @Description: 二叉排序树节点
 **/
@Data
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    /**
     * @param value 要查找节点的值
     * @return
     * @Description: 返回要查找节点的父节点
     * @author luoyong
     * @create 6:14 下午 2020/6/27
     * @last modify by [LuoYong 6:14 下午 2020/6/27 ]
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.getValue() == value) || (this.right != null && this.right.getValue() == value)) {
            //当前节点就是要找的
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    /**
     * @param value 要查找节点的值
     * @return
     * @Description: 根据节点的值 查找节点
     * @author luoyong
     * @create 6:08 下午 2020/6/27
     * @last modify by [LuoYong 6:08 下午 2020/6/27 ]
     */
    public Node search(int value) {
        if (value == this.getValue()) {
            //当前节点就是我们要查找的节点
            return this;
        } else if (value < this.getValue()) {
            //值小于当前节点 往左找
            if (null == this.left) {
                //左子树为空
                return null;
            } else {
                //继续递归查找
                return this.left.search(value);
            }
        } else {
            //值大于当前节点 往右找
            if (null == this.right) {
                return null;
            } else {
                //向右子树递归查找
                return this.right.search(value);
            }
        }
    }


    /**
     * @param node 要添加的节点
     * @return void
     * @Description: 添加节点
     * @author luoyong
     * @create 6:00 下午 2020/6/27
     * @last modify by [LuoYong 6:00 下午 2020/6/27 ]
     */
    public void add(Node node) {
        if (null == node) {
            System.out.println("要插入的节点为空");
            return;
        }
        //判断传入节点的值和当前子树的根节点的值关系
        if (node.value < this.value) {
            //当前节点的值小于根节点的值 往左边添加
            if (null == this.left) {
                this.left = node;
            } else {
                //继续向下递归
                this.left.add(node);
            }
        } else {
            //要插入的节点大于等于当前节点
            if (null == this.right) {
                this.right = node;
            } else {
                //向右递归添加
                this.right.add(node);
            }
        }
    }


    /**
     * @return void
     * @Description: 中序遍历
     * @author luoyong
     * @create 5:57 下午 2020/6/27
     * @last modify by [LuoYong 5:57 下午 2020/6/27 ]
     */
    public void infixOrder() {
        //左子树
        if (this.left != null) {
            this.left.infixOrder();
        }

        //当前节点
        System.out.println(this);

        //右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
