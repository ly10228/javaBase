package com.ly.senior.datastructure.stack;

import lombok.Data;

import java.util.Arrays;

/**
 * @author luoyong
 * @Description: ArrayStack 数组模拟栈
 * @create 2019-08-25 14:53
 * @last modify by [LuoYong 2019-08-25 14:53]
 **/
@Data
public class ArrayStack {
    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组 数组模拟栈。数据就存放在数组当中
     */
    private int[] stack;

    /**
     * 栈顶 初始化值为-1
     */
    private int top = -1;

    /**
     * 构造器初始化数组
     *
     * @param maxSize 数组大小
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈是否满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * @param value
     * @return void
     * @Description: 入栈
     * @author luoyong
     * @create 14:59 2019/8/25
     * @last modify by [LuoYong 14:59 2019/8/25 ]
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * @param
     * @return void
     * @Description: 出栈
     * @author luoyong
     * @create 15:02 2019/8/25
     * @last modify by [LuoYong 15:02 2019/8/25 ]
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈里面没有数据");
            return 0;
        }
        int popValue = stack[top];
        top--;
        return popValue;
    }

    /**
     * @param
     * @return void
     * @Description: 遍历栈
     * @author luoyong
     * @create 15:04 2019/8/25
     * @last modify by [LuoYong 15:04 2019/8/25 ]
     */
    public void list() {
        Arrays.stream(stack).forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @Description: 遍历
     * @author luoyong
     * @create 15:07 2019/8/25
     * @last modify by [LuoYong 15:07 2019/8/25 ]
     */
    public void showTop() {
        if (isEmpty()) {
            System.out.println("栈内元素为空");
            return;
        }
        //从top位置开始遍历
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 获取栈顶元素的值
     *
     * @return
     */
    public  int getTopValue() {
        return stack[top];
    }


}
