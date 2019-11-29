package com.ly.base.thread.create.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author luoyong
 *  * @create 2019-11-29 10:00
 *  * @last modify by [luoyong 2019-11-29 10:00]
 * @Description: CallableCreateThreadTest
 * 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1. call()可以有返回值的。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 **/
public class CallableCreateThreadTest {
    public static void main(String[] args) {

        //3.创建Callable接口实现类的对象
        CallableThread callableThread = new CallableThread();

        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(callableThread);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        Thread t1 = new Thread(futureTask);
        t1.setName("实线Callable接口的线程");
        t1.start();

        try {
            int sum = (Integer) futureTask.get();
            System.out.println("线程运行的结果是:" + sum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

//1:创建一个Callable接口的实现类
class CallableThread implements Callable {

    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}