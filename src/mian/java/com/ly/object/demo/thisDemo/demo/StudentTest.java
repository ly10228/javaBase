package com.ly.object.demo.thisDemo.demo;


import com.ly.object.demo.thisDemo.dto.Student;

/**
 * @author dell
 * @Description: TODO
 * @create 2018-11-20 23:13
 * @last modify by [dell 2018-11-20 23:13]
 **/
public class StudentTest {
    public static void main(String[] args) {
        //创建学生对象
        Student s = new Student();

        //给成员变量赋值
        s.setName("林青霞");
        s.setAge(27);
        //获取数据
        System.out.println(s.getName()+"---"+s.getAge());
    }
}
