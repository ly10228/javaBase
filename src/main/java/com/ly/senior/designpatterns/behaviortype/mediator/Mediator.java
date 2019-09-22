package com.ly.senior.designpatterns.behaviortype.mediator;

/**
 * @author luoyong
 * @Description: Mediator
 * @create 2019-09-22 16:08
 * @last modify by [LuoYong 2019-09-22 16:08]
 **/
public abstract class Mediator {

    /**
     * @param colleagueName
     * @param colleague
     * @return void
     * @Description: 将给中介者对象，加入到集合中
     * @author luoyong
     * @create 16:14 2019/9/22
     * @last modify by [LuoYong 16:14 2019/9/22 ]
     */
    public abstract void Register(String colleagueName, Colleague colleague);

    /**
     * @param stateChange
     * @param colleagueName
     * @return void
     * @Description: 接收消息, 具体的同事对象发出
     * @author luoyong
     * @create 16:15 2019/9/22
     * @last modify by [LuoYong 16:15 2019/9/22 ]
     */
    public abstract void GetMessage(int stateChange, String colleagueName);

    public abstract void SendMessage();
}
