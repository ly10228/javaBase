package com.ly.senior.designpatterns.structured.proxy.dynamic;

/**
 * @author luoyong
 * @Description: ITeacherDao
 * @create 2019-09-15 22:31
 * @last modify by [LuoYong 2019-09-15 22:31]
 **/
public interface ITeacherDao {

    /**
     * 授课方法
     */
    void teach();

    void sayHello(String name);
}
