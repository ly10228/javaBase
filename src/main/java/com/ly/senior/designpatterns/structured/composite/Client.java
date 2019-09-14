package com.ly.senior.designpatterns.structured.composite;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-14 23:28
 * @last modify by [LuoYong 2019-09-14 23:28]
 **/
public class Client {

    @Test
    public void test() {
        //从大到小创建对象 学校
        OrganizationComponent university = new University("许昌学院", " 八一路88号 ");

        //创建 学院
        OrganizationComponent computerCollege = new College("计算机学院", " 计算机学院 ");
        OrganizationComponent infoEngineercollege = new College("信息工程学院", " 信息工程学院 ");


        //创建各个学院下面的系(专业)
        computerCollege.add(new Department("软件工程", " 软件工程不错 "));
        computerCollege.add(new Department("网络工程", " 网络工程不错 "));
        computerCollege.add(new Department("计算机科学与技术", " 计算机科学与技术是老牌的专业 "));

        infoEngineercollege.add(new Department("通信工程", " 通信工程不好学 "));
        infoEngineercollege.add(new Department("信息工程", " 信息工程好学 "));

        //将学院加入到 学校
        university.add(computerCollege);
        university.add(infoEngineercollege);

//        university.print();
        infoEngineercollege.print();
    }
}
