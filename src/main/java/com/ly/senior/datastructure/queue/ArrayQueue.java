package com.ly.senior.datastructure.queue;

/**
 * @author luoyong
 * @Description: ArrayQueue 模拟队列 只能用一次
 * @create 2019-07-17 8:04
 * @last modify by [LuoYong 2019-07-17 8:04]
 **/
public class ArrayQueue {
    // 表示数组的最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 该数据用于存放数据, 模拟队列
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    /**
     * @param
     * @return boolean
     * @Description: isFull 判断队列元素是否是满的
     * @author luoyong
     * @create 10:10 2019/7/21
     * @last modify by [LuoYong 10:10 2019/7/21 ]
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * @param
     * @return boolean
     * @Description: isEmpty 判断队列是否为空
     * @author luoyong
     * @create 10:11 2019/7/21
     * @last modify by [LuoYong 10:11 2019/7/21 ]
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * @param n
     * @return void
     * @Description: addQueue 添加数据进队列
     * @author luoyong
     * @create 10:20 2019/7/21
     * @last modify by [LuoYong 10:20 2019/7/21 ]
     */
    public void addQueue(int n) {
        //1：队列是否是满的
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        //队尾后移
        rear++;
        arr[rear] = n;
    }

    /**
     * @param
     * @return int
     * @Description: removeQueue 获取队列数据 出队列
     * @author luoyong
     * @create 10:49 2019/7/21
     * @last modify by [LuoYong 10:49 2019/7/21 ]
     */
    public int removeQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //对首后移
        front++;
        return arr[front];
    }

    /**
     * @param
     * @return void
     * @Description: showQueue 显示所有的队列数据
     * @author luoyong
     * @create 10:52 2019/7/21
     * @last modify by [LuoYong 10:52 2019/7/21 ]
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * @param
     * @return int
     * @Description: getHeadQueue 获取头数据
     * @author luoyong
     * @create 10:55 2019/7/21
     * @last modify by [LuoYong 10:55 2019/7/21 ]
     */
    public int getHeadQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }


}
