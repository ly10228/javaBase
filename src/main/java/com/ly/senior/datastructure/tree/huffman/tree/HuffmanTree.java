package com.ly.senior.datastructure.tree.huffman.tree;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2020-06-22 1:52 下午
 *  * @last modify by [luoyong 2020-06-22 1:52 下午]
 * @Description: 赫夫曼树
 **/
public class HuffmanTree {

    /**
     * @param root
     * @return void
     * @Description: 前序遍历
     * @author luoyong
     * @create 1:54 下午 2020/6/22
     * @last modify by [LuoYong 1:54 下午 2020/6/22 ]
     */
    public static void preOrder(Node root) {
        if (null != root) {
            root.preOrder();
        } else {
            System.out.println("空树 无法进行遍历");
        }
    }


    /**
     * @param arr 数组
     * @return
     * @Description: 创建赫夫曼树
     * 思路
     * 1：从小到大进行排序, 将每一个数据，每个数据都是一个节点 ， 每个节点可以看成是一颗最简单的二叉树
     * 2：取出根节点权值最小的两颗二叉树
     * 3：组成一颗新的二叉树, 该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
     * 4：再将这颗新的二叉树，以根节点的权值大小 再次排序， 不断重复  1-2-3-4 的步骤，直到数列中，所有的数据都被处理，就得到一颗赫夫曼树
     * @author luoyong
     * @create 1:59 下午 2020/6/22
     * @last modify by [LuoYong 1:59 下午 2020/6/22 ]
     */
    public static Node createHuffmanTree(int arr[]) {
        //1:遍历arr数组
        //2：将arr数组的每个元素构成一个一个的Node
        //3:将Node放进ArrayList当中
        List<Node> nodeList = Lists.newArrayList();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            nodeList.add(node);
        }


        while (nodeList.size() > 1) {
            //最终只有一个节点
            //重新排序  从小到大
            Collections.sort(nodeList);
            System.out.println("nodeList=" + nodeList);

            //取出根节点权值最小的两个二叉树
            //第一小
            Node leftNode = nodeList.get(0);
            //第二小
            Node rightNode = nodeList.get(1);

            //将两个权值最小的二叉树 构建成一棵二叉树
            Node parentNode = new Node(leftNode.getValue() + rightNode.getValue());
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

            //删除之前的二叉树
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);

            //将parentNode加入到集合当中
            nodeList.add(parentNode);

        }
        return nodeList.get(0);
    }

}
