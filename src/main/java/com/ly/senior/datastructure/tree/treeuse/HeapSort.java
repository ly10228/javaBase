package com.ly.senior.datastructure.tree.treeuse;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author luoyong
 * @Description: 树的应用--堆排序
 * 大顶堆
 * 小顶堆
 * 1：堆排序是利用堆这种数据结构而设计的一种排序算法，
 * 堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序
 * 2：堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆,
 * 注意 : 没有要求结点的左孩子的值和右孩子的值的大小关系
 * 3：每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * 特点：小顶堆与之相反
 * 大顶堆特点：arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i+2]  // i 对应第几个节点，i从0开始编号
 * 小顶堆：arr[i] <= arr[2*i+1] && arr[i] <= arr[2*i+2] // i 对应第几个节点，i从0开始编号
 * 总结：一般升序用大顶堆 降序用小顶堆
 * 思想：
 * 1）将待排序序列构造成一个大顶堆
 * 2）此时，整个序列的最大值就是堆顶的根节点。
 * 3）将其与末尾元素进行交换，此时末尾就为最大值。
 * 4）然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
 * 可以看到在构建大顶堆的过程中，元素的个数逐渐减少，最后就得到一个有序序列了.
 * @create 2020-06-21 22:32
 * @last modify by [LuoYong 2020-06-21 22:32]
 **/
public class HeapSort {

    /**
     * @param
     * @return void
     * @Description: 测试堆排序
     * @author luoyong
     * @create 22:34 2020/6/21
     * @last modify by [LuoYong 22:34 2020/6/21 ]
     */
    @Test
    public void test() {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param
     * @return void
     * @Description: 测试堆排序的速度
     * 堆排序的速度非常快， 8百万数据 3 秒左右。O(nlogn)
     * @author luoyong
     * @create 23:09 2020/6/21
     * @last modify by [LuoYong 23:09 2020/6/21 ]
     */
    @Test
    public void testSpeed() {
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    /**
     * @param arr 要排序的数组
     * @return void
     * @Description: 堆排序
     * @author luoyong
     * @create 22:49 2020/6/21
     * @last modify by [LuoYong 22:49 2020/6/21 ]
     */
    public void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序");
        //1:将无序序列构建成一个堆 根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //2:将堆顶的元素与末尾元素进行交换 将最大元素沉到数组末端
        //3:重新调整结构 使其满足堆定义 然后继续交换堆顶元素与当前末尾元素 反复执行调整+交换步骤
        for (int j = arr.length - 1; j >= 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组当中的索引
     * @param lenght 表示对多少个元素继续调整 lenght是在逐渐减少的
     * @return void
     * @Description: 将一个数组（二叉树---》注：二叉树与数组可以相互转换）调整成一个大顶堆
     * @author luoyong
     * @create 22:36 2020/6/21
     * @last modify by [LuoYong 22:36 2020/6/21 ]
     */
    public static void adjustHeap(int arr[], int i, int lenght) {
        //先取出当前元素的值 保存在临时变量
        int temp = arr[i];
        //开始调整
        //说明
        //1 k=i*2+1 k是i节点的左子节点
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                //左子节点的值小于右子节点的值
                //k指向右子节点
                k++;
            }
            if (arr[k] > temp) {
                //子节点大于父节点
                //把较大的值赋值给当前节点
                arr[i] = arr[k];
                //i 指定k 继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for循环结束之后 我们已经将i为父节点的树的最大值 放在了 最顶部
        //将temp值放到调整后的位置
        arr[i] = temp;

    }
}


