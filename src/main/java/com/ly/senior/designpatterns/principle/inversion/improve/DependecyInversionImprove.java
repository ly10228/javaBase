package com.ly.senior.designpatterns.principle.inversion.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: DependecyInversionImprove 面向接口编程
 * @create 2019-08-29 23:35
 * @last modify by [LuoYong 2019-08-29 23:35]
 **/
public class DependecyInversionImprove {

    /**
     * @param
     * @return void
     * @Description: 依赖倒转原则--面向接口编程
     * @author luoyong
     * @create 23:42 2019/8/29
     * @last modify by [LuoYong 23:42 2019/8/29 ]
     */
    @Test
    public void test() {
        Person person = new Person();
        //电子邮件
        person.receive(new EmailReceiverImpl());
        //微信
        person.receive(new WeChatReceiverImpl());
    }
}


/**
 * 接收消息接口
 */
interface IReceiver {
    String getInfo();
}

/**
 * 电子邮件消息
 */
class EmailReceiverImpl implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

/**
 * 微信消息
 */
class WeChatReceiverImpl implements IReceiver {
    @Override
    public String getInfo() {
        return "WeChat: hello WeChat";
    }
}


/**
 * 面向接口编程
 */
class Person {
    public void receive(IReceiver iReceiver) {
        System.out.println(iReceiver.getInfo());
    }
}