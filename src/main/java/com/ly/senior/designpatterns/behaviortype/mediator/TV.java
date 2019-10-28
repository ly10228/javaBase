package com.ly.senior.designpatterns.behaviortype.mediator;

/**
 * @author luoyong
 * @Description: TV
 * @create 2019-09-22 16:24
 * @last modify by [LuoYong 2019-09-22 16:24]
 **/
public class TV extends Colleague {

    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name, this);
    }


    @Override
    public void SendMessage(int stateChange) {
        this.GetMediator().GetMessage(stateChange, this.name);
    }

    public void StartTv() {
        System.out.println("It's time to StartTv!");
    }

    public void StopTv() {
        System.out.println("StopTv!");
    }

}
