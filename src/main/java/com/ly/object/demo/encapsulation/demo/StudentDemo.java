package com.ly.object.demo.encapsulation.demo;

import com.ly.object.demo.encapsulation.dto.Student;

/**
 * @author dell
 * @Description: TODO
 * @create 2018-11-20 22:31
 * @last modify by [dell 2018-11-20 22:31]
 **/
public class StudentDemo {
    public static void main(String[] args) {
        //创建学生对象
        Student s = new Student();
        s.show();
        System.out.println("--------------");

        //给成员变量赋值
        s.name = "林青霞";
        //s.age = 27;
        s.setAge(27);
        s.show();
        System.out.println("--------------");

        //给age赋值
        //s.age = -27; //这个数据是不合理的
        //通过方法给值
        s.setAge(-27);
        s.show();
        System.out.println("--------------");
    }
}
