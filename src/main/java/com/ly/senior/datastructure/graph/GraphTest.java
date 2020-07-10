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
     * @param vertexArr
     * @return
     * @Description: 初始化图
     * @author luoyong
     * @create 23:04 2020/7/6
     * @last modify by [LuoYong 23:04 2020/7/6 ]
     */
    private Graph initGraph(String vertexArr[]) {
        if (null == vertexArr) {
            vertexArr = new String[]{"A", "B", "C", "D", "E"};
        }
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
        return graph;
    }

    /**
     * @return void
     * @Description: 测试深度优先遍历和广度优先遍历的差别
     * @author luoyong
     * @create 5:15 下午 2020/7/10
     * @last modify by [LuoYong 5:15 下午 2020/7/10 ]
     */
    @Test
    public void testDfsBfsDiff() {
        String vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //1:创建图对象
        Graph graph = new Graph(vertexs.length);

        //2:循环添加顶点
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        //3:添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);


        //显示一把邻结矩阵
        graph.showGraph();

        //测试一把，我们的dfs遍历是否ok
        System.out.println("深度遍历");
        // A->B->C->D->E [1->2->4->8->5->3->6->7]
        graph.dfs();
        System.out.println();
        System.out.println("广度优先!");
        // A->B->C->D-E [1->2->3->4->5->6->7->8]
        graph.bfs();


    }


    /**
     * @param
     * @return void
     * @Description: 测试广度优先遍历
     * @author luoyong
     * @create 0:05 2020/7/7
     * @last modify by [LuoYong 0:05 2020/7/7 ]
     */
    @Test
    public void testBfs() {
        //初始化图
        Graph graph = initGraph(null);

        //广度优先遍历
        graph.bfs();
    }

    /**
     * @param
     * @return void
     * @Description: 测试深度优先遍历算法
     * @author luoyong
     * @create 23:00 2020/7/6
     * @last modify by [LuoYong 23:00 2020/7/6 ]
     */
    @Test
    public void testDfs() {
        //初始化图
        Graph graph = initGraph(null);

        //深度优先遍历
        graph.dfs();

    }


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
        //初始化图
        Graph graph = initGraph(null);
        //显示一把邻结矩阵
        graph.showGraph();
    }
}
