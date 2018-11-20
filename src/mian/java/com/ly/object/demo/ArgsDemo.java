package com.ly.object.demo;

/**
 * @author dell
 * @Description: 基本类型+引用类型
 * @create 2018-11-15 22:19
 * @last modify by [dell 2018-11-15 22:19]
 **/


//形式参数是基本类型
class Demo {
    public int sum(int a,int b) {
        return a + b;
    }
}

//形式参数是引用类型
class Student {
    public void show() {
        System.out.println("我爱学习");
    }
}
class StudentDemo {
    //如果你看到了一个方法的形式参数是一个类类型(引用类型)，这里其实需要的是该类的对象。
    public void method(Student s) { //调用的时候，把main方法中的s的地址传递到了这里 Student s = new Student();
        s.show();
    }
}

public class ArgsDemo {
    public static void main(String[] args) {
        //形式参数是基本类型的调用
        Demo d = new Demo();
        int result = d.sum(10,20);
        System.out.println("result:"+result);
        System.out.println("--------------");

        //形式参数是引用类型的调用
        //需求：我要调用StudentDemo类中的method()方法
        StudentDemo sd = new StudentDemo();
        //创建学生对象
        Student s = new Student();
        sd.method(s); //把s的地址给到了这里
    }
}


