package com.ly.senior.designpatterns.structured.proxy.staticproxy;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * 优点：在不修改目标对象的功能前提下面，能通过代理对象对目标功能进行扩展
 * 缺点：
 *   因为代理对象需要与被代理对象实现一样的接口，所有会有很多代理类
 *   一旦接口增加方法，目标对象与代理对象都要维护
 * @create 2019-09-15 22:27
 * @last modify by [LuoYong 2019-09-15 22:27]
 **/
public class Client {

    @Test
    public void test() {
        TeacherDao target = new TeacherDao();
        TeacherDaoProxy proxy = new TeacherDaoProxy(target);
        proxy.teach();
    }
}
