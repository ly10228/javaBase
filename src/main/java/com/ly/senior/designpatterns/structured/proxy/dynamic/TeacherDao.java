package com.ly.senior.designpatterns.structured.proxy.dynamic;

/**
 * @author luoyong
 * @Description: TODO
 * @create 2019-09-15 22:32
 * @last modify by [LuoYong 2019-09-15 22:32]
 **/
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println(" 老师授课中.... ");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
