package com.ly.senior.designpatterns.behaviortype.mediator;

/**
 * @author luoyong
 * @Description: TOColleagueDO
 * @create 2019-09-22 16:09
 * @last modify by [LuoYong 2019-09-22 16:09]
 **/
public abstract class Colleague {

    /**
     * 聚合中介者
     */
    private Mediator mediator;

    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * @param
     * @return
     * @Description: 获取中介者
     * @author luoyong
     * @create 16:13 2019/9/22
     * @last modify by [LuoYong 16:13 2019/9/22 ]
     */
    public Mediator GetMediator() {
        return this.mediator;
    }

    /**
     * @param stateChange
     * @return void
     * @Description: 向中介者发送消息
     * @author luoyong
     * @create 16:13 2019/9/22
     * @last modify by [LuoYong 16:13 2019/9/22 ]
     */
    public abstract void SendMessage(int stateChange);
}
