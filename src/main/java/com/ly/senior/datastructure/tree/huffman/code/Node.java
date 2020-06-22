package com.ly.senior.datastructure.tree.huffman.code;

import lombok.Data;

/**
 * @author luoyong
 * @Description: 节点
 * @create 2020-06-22 21:27
 * @last modify by [LuoYong 2020-06-22 21:27]
 **/
@Data
public class Node implements Comparable<Node> {
    /**
     * 存放数据本身 比如 a==》97  ''==》32 ascii码
     */
    private Byte data;

    /**
     * 权值 表示字符出现的次数
     */
    private int weight;

    private Node left;

    private Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从大到小排序
        return this.weight - o.getWeight();
    }


    /**
     * @param
     * @return void
     * @Description: 前序遍历
     * @author luoyong
     * @create 21:39 2020/6/22
     * @last modify
     * by [LuoYong 21:39 2020/6/22 ]
     */
    public void preOrder() {
        //输出当前节点
        System.out.println(this);
        //遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //遍历右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
