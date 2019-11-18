package com.ly.base.opp.classstructure.keyword.interfacekey;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: StaticProxyTest
 * @create 2019-11-18 23:05
 * @last modify by [LuoYong 2019-11-18 23:05]
 **/
public class StaticProxyTest {
    @Test
    public void  test(){
        Proxy s = new Proxy(new RealStar());
        s.confer();
        s.signContract();
        s.bookTicket();
        s.sing();
        s.collectMoney();
    }
}

interface Star {
    // 面谈
    void confer();

    // 签合同
    void signContract();

    // 订票
    void bookTicket();

    // 唱歌
    void sing();

    // 收钱
    void collectMoney();
}

//被代理类
class RealStar implements Star {

    public void confer() {
    }

    public void signContract() {
    }

    public void bookTicket() {
    }

    public void sing() {
        System.out.println("明星：歌唱~~~");
    }

    public void collectMoney() {
    }
}

//代理类
class Proxy implements Star {
    private Star real;

    public Proxy(Star real) {
        this.real = real;
    }

    public void confer() {
        System.out.println("经纪人面谈");
    }

    public void signContract() {
        System.out.println("经纪人签合同");
    }

    public void bookTicket() {
        System.out.println("经纪人订票");
    }

    public void sing() {
        real.sing();
    }

    public void collectMoney() {
        System.out.println("经纪人收钱");
    }
}