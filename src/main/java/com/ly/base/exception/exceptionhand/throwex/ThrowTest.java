package com.ly.base.exception.exceptionhand.throwex;

import java.io.Serializable;

/**
 * @author luoyong
 * @Description: ThrowTest
 * @create 2019-11-24 23:24
 * @last modify by [LuoYong 2019-11-24 23:24]
 **/
public class ThrowTest {
    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.regist(-1001);
            System.out.println(s);
        } catch (Exception e) {
//			e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}


class Student implements Serializable {

    private static final long serialVersionUID = -5577398363250466028L;

    private int id;

    public void regist(int id) {
        if (id > 0) {
            this.id = id;
        } else {
//			System.out.println("您输入的数据非法！");
            //手动抛出异常对象
//			throw new RunRuntimetimeException("您输入的数据非法！");
//			throw new Exception("您输入的数据非法！");
            throw new MyException("不能输入负数");
            //错误的
//			throw new String("不能输入负数");
        }

    }


    public void regist1(int id) {
        if (id > 0) {
            this.id = id;
        } else {
//			System.out.println("您输入的数据非法！");
            //手动抛出异常对象
            throw new RuntimeException("您输入的数据非法！");
//			throw new Exception("您输入的数据非法！");
//            throw new MyException("不能输入负数");
            //错误的
//			throw new String("不能输入负数");
        }
    }


    public void regist2(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//			System.out.println("您输入的数据非法！");
            //手动抛出异常对象
//            throw new RuntimeException("您输入的数据非法！");
            throw new Exception("您输入的数据非法！");
//            throw new MyException("不能输入负数");
            //错误的
//			throw new String("不能输入负数");
        }
    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }


}