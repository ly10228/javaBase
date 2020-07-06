package com.ly.senior.datastructure.graph;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2020-07-06 11:37 上午
 *  * @last modify by [luoyong 2020-07-06 11:37 上午]
 * @Description: 图
 * 图的表示方式有两种
 * 二维数组表示（邻接矩阵）
 * 链表表示（邻接表）
 **/
@Data
public class Graph {

    /**
     * 存储顶点集合
     */
    private List<String> vertexList;

    /**
     * 存储图对应的领结矩阵
     */
    private int[][] edges;

    /**
     * 表示边的数目
     */
    private int numOfEdges;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = Lists.newArrayList();
        numOfEdges = 0;
    }


    /**
     * @param v1     第一个点的下标
     * @param v2     第二个点的下标
     * @param weight 权重 1：有边 0：无边
     * @return void
     * @Description: 添加两个节点之间的边
     * @author luoyong
     * @create 22:16 2020/7/6
     * @last modify by [LuoYong 22:16 2020/7/6 ]
     */
    public void insertEdge(int v1, int v2, int weight) {
        //目前边没有方向 是双向的
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        //边长数量+1
        numOfEdges++;
    }

    /**
     * @param vertex
     * @return void
     * @Description: 插入结点
     * @author luoyong
     * @create 22:16 2020/7/6
     * @last modify by [LuoYong 22:16 2020/7/6 ]
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1 下标1
     * @param v2 下标2
     * @return int
     * @Description: 返回v1和v2的权值
     * @author luoyong
     * @create 22:13 2020/7/6
     * @last modify by [LuoYong 22:13 2020/7/6 ]
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * @param index 下标
     * @return java.lang.String
     * @Description: 根据下标获取对应的元素
     * @author luoyong
     * @create 22:11 2020/7/6
     * @last modify by [LuoYong 22:11 2020/7/6 ]
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }


    /**
     * @param
     * @return int
     * @Description: 得到边的条数
     * @author luoyong
     * @create 22:10 2020/7/6
     * @last modify by [LuoYong 22:10 2020/7/6 ]
     */
    public int getNumberOfEdges() {
        return numOfEdges;
    }


    /**
     * @param
     * @return void
     * @Description: 显示图对应的矩阵
     * @author luoyong
     * @create 22:09 2020/7/6
     * @last modify by [LuoYong 22:09 2020/7/6 ]
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @return int
     * @Description: 返回结点的个数
     * @author luoyong
     * @create 11:50 上午 2020/7/6
     * @last modify by [LuoYong 11:50 上午 2020/7/6 ]
     */
    public int getNumberOfVertex() {
        return vertexList.size();
    }


}
