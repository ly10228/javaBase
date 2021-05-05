package com.ly.senior.jvm.runtimearea.stack;

/**
 * @author luoyong
 *  * @create 2021-05-05 5:20 下午
 *  * @last modify by [luoyong 2021-05-05 5:20 下午]
 * @Description: StackErrorTest
 * 设置栈的大小： -Xss   (-XX:ThreadStackSize)
 * -XX:+PrintFlagsFinal
 * 查看默认栈设置大小
 * 1：jps获取到进程
 * 2： jinfo -flag ThreadStackSize pid
 **/
public class StackErrorTest {
    private static int count = 1;

    public static void main(String[] args) {
//        try {
//            TimeUnit.MILLISECONDS.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            count++;
            main(args);
        } catch (Throwable e) {

            System.out.println("递归的次数为：" + count);
        }


    }
}
