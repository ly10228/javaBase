package com.ly.senior.datastructure.graph;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2020-07-06 11:37 上午
 *  * @last modify by [luoyong 2020-07-06 11:37 上午]
 * @Description: 图
 * 为什么要有图？
 * 1）我们前面学习了线性表和树
 * 2）线性表局限于一个直接前驱和一个直接后继的关系
 * 3）树也只能有一个直接前驱也就是父节点
 * 4）当我们需要表示多对多的关系时，这里我们就用到了图
 * 1：图的表示方式有两种
 * 二维数组表示（邻接矩阵）
 * 链表表示（邻接表）
 * 2： 图的遍历
 * （1） 深度优先遍历
 * （2） 广度优先遍历
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

    /**
     * 记录节点是否被访问
     */
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = Lists.newArrayList();
        numOfEdges = 0;
    }


    /**
     * @param
     * @return void
     * @Description: 广度优先遍历
     * @author luoyong
     * @create 0:02 2020/7/7
     * @last modify by [LuoYong 0:02 2020/7/7 ]
     */
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


    /**
     * @param isVisited 记录节点是否被访问的数组
     * @param i
     * @return void
     * @Description: 广度优先遍历算法
     * 1：访问初始结点v并标记结点v为已访问
     * 2：结点v入队列
     * 3：当队列非空时，继续执行，否则算法结束
     * 4：出队列，取得队头结点u
     * 5：查找结点u的第一个邻接结点w。
     * 6：若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
     * 6.1  若结点w尚未被访问，则访问结点w并标记为已访问。
     * 6.2  结点w入队列
     * 6.3  查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6
     * @author luoyong
     * @create 23:49 2020/7/6
     * @last modify by [LuoYong 23:49 2020/7/6 ]
     */
    private void bfs(boolean[] isVisited, int i) {
        //表示队列的头节点对应的下标
        int u;
        //得到第一个邻结点的下标 w
        int w;
        //队列 记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点 输出节点信息
        System.out.print(vertexList.get(i) + "->");

        //标记为已读
        isVisited[i] = true;

        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            //取出队列头节点的下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻结点的下标
            w = getFirstNeighbor(u);
            while (w != -1) {
                //找到
                //判断是否被访问过
                if (!isVisited[w]) {
                    //没有被访问过
                    System.out.print(getValueByIndex(w) + "->");
                    //标记被访问过
                    isVisited[w] = true;
                    //加入队列
                    queue.addLast(w);
                }

                //以u为前驱节点 找w后面的下一个邻结点
                w = getNextNeighbor(u, w);
            }
        }

    }


    /**
     * @param v1
     * @param v2
     * @return int
     * @Description: 根据前一个邻结点的下标来获取下一个领结点
     * @author luoyong
     * @create 22:50 2020/7/6
     * @last modify by [LuoYong 22:50 2020/7/6 ]
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * @param i 第i个结点
     * @return int
     * @Description: 获取某一个邻结点的下标w  -1表示没有找到邻结点
     * @author luoyong
     * @create 22:47 2020/7/6
     * @last modify by [LuoYong 22:47 2020/7/6 ]
     */
    public int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * @param
     * @return void
     * @Description: 深度优先遍历算法重载
     * @author luoyong
     * @create 22:55 2020/7/6
     * @last modify by [LuoYong 22:55 2020/7/6 ]
     */
    public void dfs() {
        //初始化 记录节点是否被访问的数组
        isVisited = new boolean[vertexList.size()];

        //遍历所有结点  进行dfs回溯
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                //结点还没有被访问过
                dfs(isVisited, i);
            }
        }
    }

    /**
     * @param isVisited 记录节点是否被访问
     * @param i         第一次就是0
     * @return void
     * @Description: 深度优先遍历算法
     * 1  访问初始结点v，并标记结点v为已访问。
     * 2  查找结点v的第一个邻接结点w。
     * 3  若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
     * 4  若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）
     * 5  若w被访问,查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
     * @author luoyong
     * @create 22:43 2020/7/6
     * @last modify by [LuoYong 22:43 2020/7/6 ]
     */
    private void dfs(boolean[] isVisited, int i) {
        //访问该节点输出
        System.out.print(getValueByIndex(i) + "->");

        //将该结点设置成已经被访问过
        isVisited[i] = true;

        //查找结点i的第一个邻结点
        int w = getFirstNeighbor(i);
        if (w != -1) {
            //有邻结点
            if (!isVisited[w]) {
                //领结点没有被访问过
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }

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
