package com.ly.base.opp;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 匿名对象
 * 一、匿名对象的使用
 * 1.理解：我们创建的对象，没有显式的赋给一个变量名。即为匿名对象
 * 2.特征：匿名对象只能调用一次。
 * 3.使用：如下
 * @create 2019-09-26 22:41
 * @last modify by [LuoYong 2019-09-26 22:41]
 **/
public class AnonymousObjectTest {

    @Test
    public void test() {
        Phone p = new Phone();
        //p = null;
        System.out.println(p);
        p.sendEmail();
        p.playGame();

        //匿名对象
        //new Phone().sendEmail();
        //new Phone().playGame();

        new Phone().price = 1999;
        //0.0
        new Phone().showPrice();

        //**********************************
        PhoneMall mall = new PhoneMall();
        //mall.show(p);
        //匿名对象的使用
        mall.show(new Phone());

    }
}

class PhoneMall {
    public void show(Phone phone) {
        phone.sendEmail();
        phone.playGame();
    }

}


class Phone {
    double price;

    public void sendEmail() {
        System.out.println("发送邮件");
    }

    public void playGame() {
        System.out.println("玩游戏");
    }

    public void showPrice() {
        System.out.println("手机价格为：" + price);
    }

}