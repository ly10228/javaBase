package com.ly.senior.designpatterns.behaviortype.visitor;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-16 23:18
 * @last modify by [LuoYong 2019-09-16 23:18]
 **/
public class Client {
    @Test
    public void test() {
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());


        //成功
        Success success = new Success();
        objectStructure.display(success);

        System.out.println("===============");
        Fail fail = new Fail();
        objectStructure.display(fail);

        System.out.println("=======给的是待定的测评========");

        Wait wait = new Wait();
        objectStructure.display(wait);
    }
}
