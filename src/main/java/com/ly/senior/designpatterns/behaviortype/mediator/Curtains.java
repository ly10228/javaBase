package com.ly.senior.designpatterns.behaviortype.mediator;

/**
 * @author luoyong
 * @Description: Curtains 窗帘
 * @create 2019-09-22 16:20
 * @last modify by [LuoYong 2019-09-22 16:20]
 **/
public class Curtains extends Colleague {

    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name, this);
    }

    @Override
    public void SendMessage(int stateChange) {
        this.GetMediator().GetMessage(stateChange, this.name);
    }

    public void UpCurtains() {
        System.out.println("I am holding Up Curtains!");
    }

}
