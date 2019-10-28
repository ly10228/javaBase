package com.ly.senior.designpatterns.behaviortype.mediator;

/**
 * @author luoyong
 * @Description: Alarm 闹钟
 * @create 2019-09-22 16:15
 * @last modify by [LuoYong 2019-09-22 16:15]
 **/
public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //在创建Alarm对象时 将自己放到ConcreteMediator对象中
        mediator.Register(name, this);
    }


    public void SendAlarm(int stateChange) {
        SendMessage(stateChange);
    }


    @Override
    public void SendMessage(int stateChange) {
        this.GetMediator().GetMessage(stateChange, this.name);
    }


}
