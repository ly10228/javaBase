package com.ly.senior.designpatterns.sgg.structural.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author luoyong
 *  * @create 2021-06-14 11:39 上午
 *  * @last modify by [luoyong 2021-06-14 11:39 上午]
 * @Description: 生成代理类
 **/
public class JdkTiktokProxy<T> implements InvocationHandler {


    /**
     * 组合被代理对象
     */
    private T target;

    public JdkTiktokProxy(T target) {
        this.target = target;
    }


    /**
     * @param t
     * @return T
     * @Description: 获取被代理对象的---代理
     * public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
     * ClassLoader loader：当前被代理对象的类加载器
     * Class<?>[] interfaces：当前被代理对象实现的接口集合
     * InvocationHandler h: 当前被代理对象执行目标方法时候 我们使用h可以定义拦截增强方法
     * @author luoyong
     * @create 11:42 上午 2021/6/14
     * @last modify by [LuoYong 11:42 上午 2021/6/14 ]
     */
    public static <T> T getProxy(T t) {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(),
                new JdkTiktokProxy(t));
    }


    /**
     * @param proxy
     * @param method
     * @param args
     * @return java.lang.Object
     * @Description: 定义目标方法的拦截逻辑；每个方法都会进来的
     * @author luoyong
     * @create 11:50 上午 2021/6/14
     * @last modify by [LuoYong 11:50 上午 2021/6/14 ]
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //反射执行
        System.out.println("真正执行被代理对象的方法");
        Object invoke = method.invoke(target, args);
        System.out.println("返回值：111111");
        return invoke;
    }
}
