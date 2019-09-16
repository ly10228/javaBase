package com.ly.senior.designpatterns.behaviortype.template.improve;

/**
 * @author luoyong
 * @Description: PureSoyaMilk
 * @create 2019-09-16 22:40
 * @last modify by [LuoYong 2019-09-16 22:40]
 **/
public class PureSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {

    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
