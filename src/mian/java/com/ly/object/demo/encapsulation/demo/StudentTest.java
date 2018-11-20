package com.ly.object.demo.encapsulation.demo;

import com.ly.object.demo.encapsulation.dto.Student;

/**
 * @author dell
 * @Description: TODO
 * @create 2018-11-20 22:59
 * @last modify by [dell 2018-11-20 22:59]
 **/
public class StudentTest {
    public static void main(String[] args) {
        //创建学生对象
        Student s = new Student();

        //使用成员变量
        //错误：被私有修饰了，外界不能直接访问了
        //System.out.println(s.name+"---"+s.age);
        System.out.println(s.getName() + "---" + s.getAge());

        //给成员变量赋值
        //s.name = "林青霞";
        //s.age = 27;
        //通过方法给赋值
        s.setName("林青霞");
        s.setAge(27);
        System.out.println(s.getName() + "---" + s.getAge());
    }
}
