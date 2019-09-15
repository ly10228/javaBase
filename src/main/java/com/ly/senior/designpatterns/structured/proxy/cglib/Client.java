package com.ly.senior.designpatterns.structured.proxy.cglib;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-15 22:55
 * @last modify by [LuoYong 2019-09-15 22:55]
 **/
public class Client {

    @Test
    public void test() {
        TeacherDao teacherDao = new TeacherDao();

        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);

        TeacherDao teacherDaoProxy = (TeacherDao) proxyFactory.getProxyInstance();
        String res = teacherDaoProxy.teach();
        System.out.println(res);
    }
}
