package com.ly.senior.designpatterns.sgg.creatation.singleton;

import java.util.Map;
import java.util.Properties;

/**
 * @author luoyong
 *  * @create 2021-06-14 2:19 下午
 *  * @last modify by [luoyong 2021-06-14 2:19 下午]
 * @Description: 测试
 **/
public class MainTest {
    public static void main(String[] args) {
        Person person1 = Person.guiguBoss();
        Person person2 = Person.guiguBoss();
        //true 两个对象地址一致 构造方法只被调用一次
        System.out.println(person1 == person2);

        Properties properties = System.getProperties();
        System.out.println(properties);

        //获取当前系统的环境变量
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv);

    }
}
