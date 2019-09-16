package com.ly.senior.designpatterns.structured.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author luoyong
 * @Description: ProxyFactory
 * @create 2019-09-15 22:33
 * @last modify by [LuoYong 2019-09-15 22:33]
 **/
public class ProxyFactory {
    /**
     * 聚合一个目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成一个代理对象
     * 并通过反射执行目标方法
     *
     * @return
     */
    public Object getProxyInstance() {
        /**
         * 1. ClassLoader loader ： 指定当前目标对象使用的类加载器, 获取加载器的方法固定
         * 2. Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
         * 3.  InvocationHandler h : 事情处理，执行目标对象的方法时，会触发事情处理器方法, 会把当前执行的目标对象方法作为参数传入
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK动态代理开始");
                //返回执行的结果
                Object returnVal = method.invoke(target, args);
                System.out.println("JDK动态代理完成");
                return returnVal;
            }
        });
    }
}
