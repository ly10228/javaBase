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
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK动态代理开始");
                Object returnVal = method.invoke(target, args);
                System.out.println("JDK动态代理完成");
                return returnVal;
            }
        });
    }
}
