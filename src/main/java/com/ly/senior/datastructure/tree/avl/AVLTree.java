package com.ly.senior.datastructure.tree.avl;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2020-06-29 5:40 下午
 *  * @last modify by [luoyong 2020-06-29 5:40 下午]
 * @Description: 自平衡二叉树
 **/
@Data
public class AVLTree {

    private AvlNode root;

    /**
     * @param node
     * @return int
     * @Description: 返回Node为根节点的二叉排序树最小节点的值
     * 删除node为根节点的二叉排序树的最小值的节点
     * @author luoyong
     * @create 6:45 下午 2020/6/27
     * @last modify by [LuoYong 6:45 下午 2020/6/27 ]
     */
    public int delRightTreeMin(AvlNode node) {
        AvlNode target = node;
        //循环的查找左子节点，就会找到最小值
        while (target.getLeft() != null) {
            target = target.getLeft();
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.getValue());
        return target.getValue();
    }

    /**
     * @param value
     * @return void
     * @Description: 根据节点的值删除节点
     * @author luoyong
     * @create 6:30 下午 2020/6/27
     * @last modify by [LuoYong 6:30 下午 2020/6/27 ]
     */
    public void delNode(int value) {
        if (null == root) {
            System.out.println("当前树为空，无法进行删除");
            return;
        }

        //根据value 查找对应的节点
        AvlNode targetNode = search(value);
        if (null == targetNode) {
            System.out.println("未找到对应的节点，无法进行删除");
            return;
        }

        if (null == root.getLeft() && null == root.getRight()) {
            //当前二叉树只有一个节点
            root = null;
            return;
        }
        //查找要删除节点的父节点
        AvlNode parent = searchParent(value);

        if (null == targetNode.getLeft() && null == targetNode.getRight()) {
            //要删除的是叶子节点
            //判断是左叶子节点 还是右子节点
            if (null != parent.getLeft() && null == parent.getRight()) {
                //左子节点
                parent.setLeft(null);
            } else if (null == parent.getLeft() && null != parent.getRight()) {
                //右子节点
                parent.setRight(null);
            }
        } else if (null != targetNode.getLeft() && null != targetNode.getRight()) {
            //删除有两颗子树的节点
            int minVal = delRightTreeMin(targetNode.getRight());
            targetNode.setValue(minVal);
        } else {
            //删除只有一颗子树的节点
            //如果我们删除的节点只有左子节点
            if (null != targetNode.getLeft()) {
                if (null != parent) {
                    //如果 targetNode 是 parent 的左子结点
                    if (parent.getLeft().getValue() == value) {
                        parent.setLeft(targetNode.getLeft());
                    } else {
                        // targetNode 是 parent 的右子结点
                        parent.setRight(targetNode.getLeft());
                    }
                } else {
                    root = targetNode.getLeft();
                }
            } else {
                //如果删除的是右子节点
                if (null != parent) {
                    //如果 targetNode 是 parent 的左子节点
                    if (parent.getLeft().getValue() == value) {
                        parent.setLeft(targetNode.getRight());
                    } else {
                        // targetNode 是 parent 的右子节点
                        parent.setRight(targetNode.getRight());
                    }
                } else {
                    root = targetNode.getRight();
                }
            }
        }
    }

    /**
     * @param value
     * @return
     * @Description: 查找要删除的结点
     * @author luoyong
     * @create 6:23 下午 2020/6/27
     * @last modify by [LuoYong 6:23 下午 2020/6/27 ]
     */
    public AvlNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * @param value
     * @return
     * @Description: 查找父结点
     * @author luoyong
     * @create 6:23 下午 2020/6/27
     * @last modify by [LuoYong 6:23 下午 2020/6/27 ]
     */
    public AvlNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    /**
     * @param node
     * @return void
     * @Description: 添加节点
     * @author luoyong
     * @create 6:27 下午 2020/6/27
     * @last modify by [LuoYong 6:27 下午 2020/6/27 ]
     */
    public void add(AvlNode node) {
        if (null == root) {
            root = node;
        } else {
            this.root.add(node);
        }
    }

    /**
     * @return void
     * @Description: 中序遍历
     * @author luoyong
     * @create 6:27 下午 2020/6/27
     * @last modify by [LuoYong 6:27 下午 2020/6/27 ]
     */
    public void infixOrder() {
        if (null == this.root) {
            System.out.println("当前节点为空");
            return;
        }
        this.root.infixOrder();
    }
}
