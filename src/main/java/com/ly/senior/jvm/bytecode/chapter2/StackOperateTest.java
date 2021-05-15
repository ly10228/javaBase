package com.ly.senior.jvm.bytecode.chapter2;

/**
 * @author luoyong
 *  * @create 2021-05-15 9:39 下午
 *  * @last modify by [luoyong 2021-05-15 9:39 下午]
 * @Description: 指令6：操作数栈管理指令
 **/
public class StackOperateTest {
    public void print() {
        Object obj = new Object();
//        String info = obj.toString();
        obj.toString();
    }

    //类似的
    public void foo() {
        bar();
    }

    public long bar() {
        return 0;
    }

    public long nextIndex() {
        return index++;
    }

    private long index = 0;
}
