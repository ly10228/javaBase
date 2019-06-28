package com.ly.object.demo;

/**
 * @author dell
 * @Description: 匿名对象
 * @create 2018-11-20 8:35
 * @last modify by [dell 2018-11-20 8:35]
 **/
public class NoNameDemo {
    public static void main(String[] args) {
        //带名字的调用
        Student s = new Student();
        s.show();
        s.show();
        System.out.println("--------------");

        //匿名对象
        //new Student();
        //匿名对象调用方法
        new Student().show();
        new Student().show(); //这里其实是重新创建了一个新的对象
        System.out.println("--------------");


        //匿名对象作为实际参数传递
        StudentDemo sd = new StudentDemo();
        //Student ss = new Student();
        //sd.method(ss); //这里的s是一个实际参数
        //匿名对象
        sd.method(new Student());

        //在来一个
        new StudentDemo().method(new Student());
    }
}
