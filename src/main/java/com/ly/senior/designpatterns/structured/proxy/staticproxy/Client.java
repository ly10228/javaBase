package com.ly.senior.designpatterns.structured.proxy.staticproxy;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
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
