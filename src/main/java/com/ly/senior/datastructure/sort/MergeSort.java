package com.ly.senior.datastructure.sort;

/**
 * @author luoyong
 *  * @create 2020-05-20 9:39 下午
 *  * @last modify by [luoyong 2020-05-20 9:39 下午]
 * @Description: 归并排序
 **/
public class MergeSort {

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     * @return void
     * @Description: 合并方法
     * @author luoyong
     * @create 9:44 下午 2020/5/20
     * @last modify by [LuoYong 9:44 下午 2020/5/20 ]
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //初始化i 左边有序序列的初始索引
        int i = left;
        //初始化j 右边有序序列的初始索引值
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;
        //1:先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //将左边的元素填充到temp数组
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            } else {
                //反之
                //右边的大于左边的元素 右边的元素填充到数组当中
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }

        //2:把剩余数组的一边数据依次全部填充到temp
        while (i <= mid) {
            //左边的有序序列还有剩余元素 就全部填充到temp
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right) {
            //右边的有序序列还有剩余元素 就全部填充到temp
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }

        //3: 将temp数组的元素都拷贝到arr 不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
