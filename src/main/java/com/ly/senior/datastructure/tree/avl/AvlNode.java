package com.ly.senior.datastructure.tree.avl;

import lombok.Data;

/**
 * @author luoyong
 * @Description: AvlNode
 * @create 2020-06-28 23:43
 * @last modify by [LuoYong 2020-06-28 23:43]
 **/
@Data
public class AvlNode {
    private int value;
    private AvlNode left;
    private AvlNode right;

    public AvlNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AvlNode{" +
                "value=" + value +
                '}';
    }


    /**
     * =================================================================================================================
     * 相比较与二叉排序树 AVL多出来的代码20200628 start............
     * =================================================================================================================
     */

    /**
     * @return void
     * @Description: 右旋转 左子树-右子树>1
     * @author luoyong
     * @create 9:40 下午 2020/6/30
     * @last modify by [LuoYong 9:40 下午 2020/6/30 ]
     */
    public void rightRotate() {
        //1:创建新的节点 以当前根节点的值为值
        AvlNode newNode = new AvlNode(value);

    }

    /**
     * @return void
     * @Description: 左旋转 右子树--
     * @author luoyong
     * @create 9:00 下午 2020/6/30
     * @last modify by [LuoYong 9:00 下午 2020/6/30 ]
     */
    public void leftRotate() {
        //1:创建新的节点 以当前根节点的值为值
        AvlNode newNode = new AvlNode(this.value);

        //2:新节点的左子树-->当前节点的左子树
        newNode.left = left;

        //3:新节点的右子树-->当前节点右子树的右子树
        newNode.right = right.left;

        //4:当前节点的值替换成有节点的值
        value = right.value;

        //5:当前节点的右子树-->当前节点的右子树的右子树
        right = right.right;

        //6:当前节点的左子树-->新的节点
        left = newNode;
    }

    /**
     * @param
     * @return int
     * @Description: 获取左子树的高度
     * @author luoyong
     * @create 23:54 2020/6/28
     * @last modify by [LuoYong 23:54 2020/6/28 ]
     */
    public int leftHeight() {
        if (null == left) {
            return 0;
        }
        return left.height();
    }

    /**
     * @param
     * @return int
     * @Description: 获取右子树的高度
     * @author luoyong
     * @create 23:55 2020/6/28
     * @last modify by [LuoYong 23:55 2020/6/28 ]
     */
    public int rightHeight() {
        if (null == right) {
            return 0;
        }
        return right.height();
    }

    /**
     * @param
     * @return int
     * @Description: 返回以该节点为根节点的树的高度
     * @author luoyong
     * @create 23:52 2020/6/28
     * @last modify by [LuoYong 23:52 2020/6/28 ]
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


    /**
     * =================================================================================================================
     * 相比较与二叉排序树 AVL多出来的代码20200628 end............
     * =================================================================================================================
     */

    /**
     * @param value 要查找节点的值
     * @return
     * @Description: 返回要查找节点的父节点
     * @author luoyong
     * @create 6:14 下午 2020/6/27
     * @last modify by [LuoYong 6:14 下午 2020/6/27 ]
     */
    public AvlNode searchParent(int value) {
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
    public AvlNode search(int value) {
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
    public void add(AvlNode node) {
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

        //右子树的高度-左子树高度>1 进行左旋转
        if (rightHeight() - leftHeight() > 1) {
            //左旋转
            leftRotate();
        }
        return;
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
