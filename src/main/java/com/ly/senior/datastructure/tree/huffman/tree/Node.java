package com.ly.senior.datastructure.tree.huffman.tree;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2020-06-22 11:33 上午
 *  * @last modify by [luoyong 2020-06-22 11:33 上午]
 * @Description: 节点
 **/
@Data
public class Node implements Comparable<Node> {
    /**
     * 节点权值
     */
    private int value;
    /**
     * 指向左子节点
     */
    private Node left;
    /**
     * 指向右子节点
     */
    private Node right;

    public Node(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        //表示从小到大
        return this.value - o.getValue();
    }


    /**
     * @return void
     * @Description: 前序遍历
     * 输出父节点 遍历左子树 遍历右子树
     * @author luoyong
     * @create 11:37 上午 2020/6/22
     * @last modify by [LuoYong 11:37 上午 2020/6/22 ]
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
