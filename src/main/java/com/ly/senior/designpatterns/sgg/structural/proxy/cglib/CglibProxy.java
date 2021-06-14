package com.ly.senior.designpatterns.sgg.structural.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author luoyong
 *  * @create 2021-06-14 11:58 上午
 *  * @last modify by [luoyong 2021-06-14 11:58 上午]
 * @Description: cglib帮我们创建出代理对象
 **/
public class CglibProxy {
    public static <T> T createProxy(T t) {

        //1:创建一个增强器
        Enhancer enhancer = new Enhancer();

        //2:设置要增强那个类的功能，增强器为这个类动态的创建一个子类
        enhancer.setSuperclass(t.getClass());

        //3:设置回调

        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o
             * @param method 为了能获取到原方法的一些元数据信息
             * @param args
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //编写拦截逻辑
                System.out.println("cglib上场le .......xxx");
                return methodProxy.invokeSuper(o, args);
            }
        });

        Object o = enhancer.create();
        return (T) o;
    }
}
