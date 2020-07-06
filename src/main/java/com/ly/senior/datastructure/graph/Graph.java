package com.ly.senior.datastructure.graph;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author luoyong
 *  * @create 2020-07-06 11:37 上午
 *  * @last modify by [luoyong 2020-07-06 11:37 上午]
 * @Description: 图
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
