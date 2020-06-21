package com.ly.senior.datastructure.tree.threadedbinarytree;

import com.ly.senior.datastructure.tree.common.HeroNode;
import lombok.Data;

/**
 * @author luoyong
 * @Description: 线索化二叉树
 * @create 2020-06-21 17:20
 * @last modify by [LuoYong 2020-06-21 17:20]
 **/
@Data
public class ThreadedBinaryTree {
    private HeroNode root;
    /**
     * 为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
     * 在递归进行线索化时，pre 总是保留前一个结点
     */
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }


    /**
     * @param
     * @return void
     * @Description: 遍历线索化二叉树
     * @author luoyong
     * @create 17:46 2020/6/21
     * @last modify by [LuoYong 17:46 2020/6/21 ]
     */
    public void threadedList() {
        //定一个变量 存储当前遍历的节点 从root开始
        HeroNode node = root;
        while (node != null) {
            //循环找到leftType == 1的节点 第一找到的就是8
            //后面随着遍历而变化 因为当leftType==1时 说明该节点是按照线索化
            //处理后面的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            //替换整个遍历的节点
            node = node.getRight();
        }
    }

    /**
     * @param heroNode
     * @return void
     * @Description: 线索化二叉树
     * 编写对二叉树进行中序线索化的方法 左 --》父--》右
     * @author luoyong
     * @create 17:31 2020/6/21
     * @last modify by [LuoYong 17:31 2020/6/21 ]
     */
    public void threadedNodes(HeroNode heroNode) {
        if (null == heroNode) {
            //节点为空 不能进行线索化
            return;
        }
        //1 线索化左子树
        threadedNodes(heroNode.getLeft());

        //2:处理当前节点
        //处理当前节点的前驱节点
        //以8节点来理解 8节点的left=null 8节点的leftType=1
        if (heroNode.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            heroNode.setLeft(pre);
            //修改当前节点的左指针类型，指向前驱节点
            heroNode.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(heroNode);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //!!!每处理一个节点之后 让当前节点是下一个节点的前驱节点
        pre = heroNode;

        //3:线索化右子树
        threadedNodes(heroNode.getRight());
    }
}
