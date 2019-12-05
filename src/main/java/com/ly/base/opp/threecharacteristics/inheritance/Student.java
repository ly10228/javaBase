package com.ly.base.opp.threecharacteristics.inheritance;


/**
 * @author luoyong
 * @Description: Student
 * @create 2019-10-29 7:55
 * @last modify by [LuoYong 2019-10-29 7:55]
 **/
public class Student extends Person {

    //	String name;
//	int age;
    String major;

    public Student() {

    }

    public Student(String name, int age, String major) {
        this.name = name;
//		this.age = age;
        setAge(age);
        this.major = major;
    }
//	public void eat(){
//		System.out.println("吃饭");
//	}
//
//	public void sleep(){
//		System.out.println("睡觉");
//	}

    public void study() {
        System.out.println("学习");
    }

    public void show() {
        System.out.println("name:" + name + ",age:" + getAge());
    }
}
