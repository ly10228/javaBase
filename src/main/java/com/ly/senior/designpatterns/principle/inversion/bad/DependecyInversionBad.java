package com.ly.senior.designpatterns.principle.inversion.bad;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: DependecyInversionBad
 * @create 2019-08-29 23:32
 * @last modify by [LuoYong 2019-08-29 23:32]
 **/
public class DependecyInversionBad {

    /**
     * @param
     * @return void
     * @Description: test
     * @author luoyong
     * @create 23:36 2019/8/29
     * @last modify by [LuoYong 23:36 2019/8/29 ]
     */
    @Test
    public void test() {
        Person p = new Person();
        p.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

/**
 * 完成Person接收消息功能
 * 1. 如果我们获取的对象是 微信，短信等等，则新增类，同时Perons也要增加相应的接收方法
 * 2: 解决思路：引入一个抽象的接口IReceiver, 表示接收者, 这样Person类与接口IReceiver发生依赖'
 * 3: 因为Email, WeiXin 等等属于接收的范围，他们各自实现IReceiver 接口就ok, 这样我们就符号依赖倒转原则
 */
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}