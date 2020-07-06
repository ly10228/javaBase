package com.ly.senior.datastructure.graph;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2020-07-06 11:47 上午
 *  * @last modify by [luoyong 2020-07-06 11:47 上午]
 * @Description: GraphTest
 **/
public class GraphTest {

    /**
     * @param
     * @return void
     * @Description: 测试生成一个图
     * @author luoyong
     * @create 22:20 2020/7/6
     * @last modify by [LuoYong 22:20 2020/7/6 ]
     */
    @Test
    public void testAddGraph() {
        String vertexArr[] = {"A", "B", "C", "D", "E"};
        //1:创建图对象
        Graph graph = new Graph(vertexArr.length);

        //2:循环添加顶点
        for (String vertex : vertexArr) {
            graph.insertVertex(vertex);
        }

        //3:添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示一把邻结矩阵
        graph.showGraph();
    }
}
