package com.ly.senior.datastructure;

import org.junit.Test;


/**
 * @author luoyong
 * @Description: SparseArray 稀疏数组
 * @create 2019-07-13 16:59
 * @last modify by [LuoYong 2019-07-13 16:59]
 **/
public class SparseArray {

    /**
     * @param
     * @return void
     * @Description: 将二维数组转换成稀疏数组
     * 将稀疏数组还原成二维数组
     * @author luoyong
     * @create 17:05 2019/7/13
     * @last modify by [LuoYong 17:05 2019/7/13 ]
     */
    @Test
    public void testSparseArray() {
        //1:创建一个11*11的二维数组
        // 0 表示没有棋子 1表示黑子 2表示白子
        int priChessArr[][] = new int[11][11];
        priChessArr[1][2] = 1;
        priChessArr[2][3] = 2;
        priChessArr[4][5] = 2;
        //打印二维数组
        System.out.println("原始数组是");
        for (int[] row : priChessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 统计二维数据当中非0的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (priChessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.printf("二维数组非0的数量是 %d", sum);
        System.out.println();

        if (sum <= 0) {
            return;
        }

        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值 1行1列 原二维数组的行数 1行2列 原二维数组的列数 1行3列 原二维数组非0的个数
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数据 将非零的值存入到稀疏数据当中
        //用来记录非0的个数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                int value = priChessArr[i][j];
                if (value != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = value;
                }
            }
        }
        System.out.println("稀疏数组的数据是");
        //打印稀疏数据
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组还原成二位数组
        int rowLength = sparseArr[0][0];
        int columnLength = sparseArr[0][1];

        int[][] newArr = new int[rowLength][columnLength];
        for (int i = 1; i < sparseArr.length; i++) {
            int newArrRow = sparseArr[i][0];
            int newArrColumn = sparseArr[i][1];
            int newValue = sparseArr[i][2];
            newArr[newArrRow][newArrColumn] = newValue;
        }
        System.out.println("稀疏数组还原成二维数组是");
        for (int[] row : newArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
