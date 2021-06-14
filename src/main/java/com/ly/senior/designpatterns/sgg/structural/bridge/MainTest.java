package com.ly.senior.designpatterns.sgg.structural.bridge;

/**
 * @author luoyong
 *  * @create 2021-06-14 5:43 下午
 *  * @last modify by [luoyong 2021-06-14 5:43 下午]
 * @Description: 测试
 **/
public class MainTest {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        iPhone.setSale(new StudentSale("学生", 1));
        String phone = iPhone.getPhone();
        System.out.println(phone);
    }
}
