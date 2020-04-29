package com.ly.senior.datastructure.recursion;

/**
 * @author luoyong
 *  * @create 2020-04-29 9:53 下午
 *  * @last modify by [luoyong 2020-04-29 9:53 下午]
 * @Description: MiGong
 **/
public class MiGong {
    /**
     * @return void
     * @Description: 模拟迷宫
     * @author luoyong
     * @create 10:03 下午 2020/4/29
     * @last modify by [LuoYong 10:03 下午 2020/4/29 ]
     */
    public static void main(String[] args) {
        //1:先模拟一个二维数组
        int[][] map = new int[8][7];
        // 使用1表示墙
        //上下墙置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右墙为1
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //设置以下两个挡板 产生回溯现象
        //map[1][2] = 1;
        //map[2][2] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            //打印一行之后换行
            System.out.println();
        }

        //使用递归回溯给小球找路
//        setWay(map, 1, 1);
//        System.out.println("小球走过的路径1是*******");
//        //输出小球走过的路径
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            //打印一行之后换行
//            System.out.println();
//        }

        setWay2(map, 1, 1);
        System.out.println("小球走过的路径2是*******");
        //输出小球走过的路径
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            //打印一行之后换行
            System.out.println();
        }

    }

    /**
     * @param map 地图
     * @param i
     * @param j
     * @return
     * @Description: 1：i、j小球起始位置
     * 2：map 表示地图
     * 3 如果小球走到map[6][5]的位置，说明通路找到
     * 4 约定 当map[i][j] 为0 表示该点没有走过 1:表示墙 2：通路 3：表示改点已经走过 但是走不通
     * 5：在走迷宫的时候 需要确定一个策略 下->右->上->左
     * @author luoyong
     * @create 10:18 下午 2020/4/29
     * @last modify by [LuoYong 10:18 下午 2020/4/29 ]
     */
    private static Boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                //表示当前路还没有走过
                //假定该节点是可以走通的
                map[i][j] = 2;
                //按照制定好的策略走 下->右->上->左
                if (setWay(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //表示此路不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //map[i][j] != 0 可能是1 2 3
                return false;
            }
        }
    }


    /**
     * @param map 地图
     * @param i
     * @param j
     * @return
     * @Description: 1：i、j小球起始位置
     * 2：map 表示地图
     * 3 如果小球走到map[6][5]的位置，说明通路找到
     * 4 约定 当map[i][j] 为0 表示该点没有走过 1:表示墙 2：通路 3：表示改点已经走过 但是走不通
     * 5：在走迷宫的时候 需要确定一个策略 上->右->下->左
     * @author luoyong
     * @create 10:18 下午 2020/4/29
     * @last modify by [LuoYong 10:18 下午 2020/4/29 ]
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到ok
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                //按照策略 上->右->下->左
                map[i][j] = 2; // 假定该点是可以走通.
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { //向下
                    return true;
                } else if (setWay2(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }
}
