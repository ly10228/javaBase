package com.ly.senior.designpatterns.structured.proxy.staticproxy;

/**
 * @author luoyong
 * @Description: TeacherDao 被代理对象
 * @create 2019-09-15 22:23
 * @last modify by [LuoYong 2019-09-15 22:23]
 **/
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中 。。。。");
    }
}
