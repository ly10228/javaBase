package com.ly.senior.datastructure.tree.binarysorttree;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2020-06-27 6:22 下午
 *  * @last modify by [luoyong 2020-06-27 6:22 下午]
 * @Description: 排序二叉树
 * 删除逻辑
 * 第一种情况:
 * 删除叶子节点 (比如：2, 5, 9, 12)
 * 思路
 * (1) 需求先去找到要删除的结点  targetNode
 * (2)  找到targetNode 的 父结点 parent
 * (3)  确定 targetNode 是 parent的左子结点 还是右子结点
 * (4)  根据前面的情况来对应删除
 * 左子结点 parent.left = null
 * 右子结点 parent.right = null;
 * 第二种情况: 删除只有一颗子树的节点 比如 1
 * 思路
 * (1) 需求先去找到要删除的结点  targetNode
 * (2)  找到targetNode 的 父结点 parent
 * (3) 确定targetNode 的子结点是左子结点还是右子结点
 * (4) targetNode 是 parent 的左子结点还是右子结点
 * (5) 如果targetNode 有左子结点
 * 5. 1 如果 targetNode 是 parent 的左子结点
 * parent.left = targetNode.left;
 * 5.2  如果 targetNode 是 parent 的右子结点
 * parent.right = targetNode.left;
 * (6) 如果targetNode 有右子结点
 * 6.1 如果 targetNode 是 parent 的左子结点
 * parent.left = targetNode.right;
 * 6.2 如果 targetNode 是 parent 的右子结点
 * parent.right = targetNode.right
 *
 *
 * 情况三 ： 删除有两颗子树的节点. (比如：7, 3，10 )
 * 思路
 * (1) 需求先去找到要删除的结点  targetNode
 * (2)  找到targetNode 的 父结点 parent
 * (3)  从targetNode 的右子树找到最小的结点
 * (4) 用一个临时变量，将 最小结点的值保存 temp = 11
 * (5)  删除该最小结点
 * (6)  targetNode.value = temp
 **/
@Data
public class BinarySortTree {
    private Node root;


    /**
     * @param node
     * @return int
     * @Description: 返回Node为根节点的二叉排序树最小节点的值
     * 删除node为根节点的二叉排序树的最小值的节点
     * @author luoyong
     * @create 6:45 下午 2020/6/27
     * @last modify by [LuoYong 6:45 下午 2020/6/27 ]
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
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
        Node targetNode = search(value);
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
        Node parent = searchParent(value);

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
    public Node search(int value) {
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
    public Node searchParent(int value) {
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
    public void add(Node node) {
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
