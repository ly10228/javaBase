package com.ly.senior.designpatterns.structured.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author luoyong
 * @Description: ProxyFactory
 * @create 2019-09-15 22:47
 * @last modify by [LuoYong 2019-09-15 22:47]
 **/
public class ProxyFactory implements MethodInterceptor {

    /**
     * 聚合一个目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * @param
     * @return
     * @Description: 返回一个代理对象 target的代理对象
     * @author luoyong
     * @create 22:50 2019/9/15
     * @last modify by [LuoYong 22:50 2019/9/15 ]
     */
    public Object getProxyInstance() {
        //1:创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2:设置父类
        enhancer.setSuperclass(target.getClass());
        //3:设置回调函数
        enhancer.setCallback(this);
        //4:创建子类，即代理对象
        return enhancer.create();
    }


    /**
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @Description: 重写intercept 会调用目标对象的方法
     * @author luoyong
     * @create 22:53 2019/9/15
     * @last modify by [LuoYong 22:53 2019/9/15 ]
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式 ~~ 开始");
        Object returnVal = method.invoke(target, objects);
        System.out.println("Cglib代理模式 ~~ 提交");
        return returnVal;
    }
}
