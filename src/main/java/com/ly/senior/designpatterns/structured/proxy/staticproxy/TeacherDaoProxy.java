package com.ly.senior.designpatterns.structured.proxy.staticproxy;

/**
 * @author luoyong
 * @Description: TeacherDaoProxy 代理对象 静态代理
 * @create 2019-09-15 22:23
 * @last modify by [LuoYong 2019-09-15 22:23]
 **/
public class TeacherDaoProxy implements ITeacherDao {

    /**
     * 目标对象 通过接口来聚合
     */
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理  完成某些操作 。。。。。 ");
        target.teach();
        System.out.println("提交 。。。。。");
    }
}
