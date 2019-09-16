package com.ly.senior.designpatterns.behaviortype.template;

/**
 * @author luoyong
 * @Description: PeanutSoyaMilk
 * @create 2019-09-16 22:32
 * @last modify by [LuoYong 2019-09-16 22:32]
 **/
public class PeanutSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("加入上好的花生");
    }
}
