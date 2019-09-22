package com.ly.senior.designpatterns.behaviortype.observer.improve;

/**
 * @author luoyong
 * @Description: 观察者接口，有观察者来实现
 * @create 2019-09-22 10:58
 * @last modify by [LuoYong 2019-09-22 10:58]
 **/
public interface Observer {

    /**
     * @param temperature
     * @param pressure
     * @param humidity
     * @return void
     * @Description: 更新气象数据
     * @author luoyong
     * @create 10:58 2019/9/22
     * @last modify by [LuoYong 10:58 2019/9/22 ]
     */
    void update(float temperature, float pressure, float humidity);

}
