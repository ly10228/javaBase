package com.ly.senior.designpatterns.behaviortype.mediator;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author luoyong
 * @Description: 具体的中介类
 * @create 2019-09-22 16:26
 * @last modify by [LuoYong 2019-09-22 16:26]
 **/
public class ConcreteMediator extends Mediator {

    private Map<String, Colleague> colleagueMap;

    private Map<String, String> interMap;

    public ConcreteMediator() {
        this.colleagueMap = Maps.newHashMap();
        this.interMap = Maps.newHashMap();
    }

    @Override
    public void Register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);

        if (colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        } else if (colleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", colleagueName);
        } else if (colleague instanceof TV) {
            interMap.put("TV", colleagueName);
        } else if (colleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        }
    }

    /**
     * @param stateChange
     * @param colleagueName
     * @return void GetMessage
     * @Description: 得到消息 完成对应的任务
     * 中介者在这个方法，协调各个具体的同事对象，完成任务
     * 闹铃响起->咖啡机开始做咖啡->窗帘自动落下->电视机开始播放
     * @author luoyong
     * @create 16:32 2019/9/22
     * @last modify by [LuoYong 16:32 2019/9/22 ]
     */
    @Override
    public void GetMessage(int stateChange, String colleagueName) {
        //1:处理闹钟发出的消息
        if (colleagueMap.get(colleagueName) instanceof Alarm) {
            if (stateChange == 0) {
                //咖啡机开始做咖啡
                ((CoffeeMachine) colleagueMap.get(interMap.get("CoffeeMachine"))).StartCoffee();
                //电视
                ((TV) colleagueMap.get(interMap.get("TV"))).StartTv();
            } else if (stateChange == 1) {
                ((TV) colleagueMap.get(interMap.get("TV"))).StopTv();
            }
        } else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
            ((Curtains) (colleagueMap.get(interMap.get("Curtains"))))
                    .UpCurtains();
        } else if (colleagueMap.get(colleagueName) instanceof TV) {

        } else if (colleagueMap.get(colleagueName) instanceof Curtains) {

        }
    }

    @Override
    public void SendMessage() {

    }
}
