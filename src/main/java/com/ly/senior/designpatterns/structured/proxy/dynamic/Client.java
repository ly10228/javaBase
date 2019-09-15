package com.ly.senior.designpatterns.structured.proxy.dynamic;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client--动态代理
 * @create 2019-09-15 22:40
 * @last modify by [LuoYong 2019-09-15 22:40]
 **/
public class Client {

    @Test
    public void test() {
        //要被代理的目标对象 TeacherDao
        ITeacherDao target = new TeacherDao();

        //生成代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        // proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyInstance=" + proxyInstance.getClass());

        proxyInstance.teach();
        proxyInstance.sayHello("201909156666");

    }
}
