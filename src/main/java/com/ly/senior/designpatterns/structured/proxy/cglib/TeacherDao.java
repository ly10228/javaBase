package com.ly.senior.designpatterns.structured.proxy.cglib;

/**
 * @author luoyong
 * @Description: TeacherDao
 * @create 2019-09-15 22:46
 * @last modify by [LuoYong 2019-09-15 22:46]
 **/
public class TeacherDao {
    public String teach() {
        System.out.println(" 老师授课中  ， 我是cglib代理，不需要实现接口 ");
        return "hello";
    }
}
