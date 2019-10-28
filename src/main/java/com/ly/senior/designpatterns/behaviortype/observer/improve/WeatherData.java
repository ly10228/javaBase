package com.ly.senior.designpatterns.behaviortype.observer.improve;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author luoyong
 * @Description: WeatherData
 * 1. 包含最新的天气情况信息
 * 2. 含有 观察者集合，使用ArrayList管理
 * 3. 当数据有更新时，就主动的调用   ArrayList, 通知所有的（接入方）就看到最新的信息
 * @create 2019-09-22 11:02
 * @last modify by [LuoYong 2019-09-22 11:02]
 **/
@Data
public class WeatherData implements Subject {

    /**
     * 温度
     */
    private float temperature;

    /**
     * 气压
     */
    private float pressure;

    /**
     * 湿度
     */
    private float humidity;

    /**
     * 观察者集合
     */
    private List<Observer> observerList;

    public WeatherData() {
        observerList = Lists.newArrayList();
    }

    /**
     * @param o
     * @return void
     * @Description: 注册一个观察者
     * @author luoyong
     * @create 11:06 2019/9/22
     * @last modify by [LuoYong 11:06 2019/9/22 ]
     */
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    /**
     * @param o
     * @return void
     * @Description: 移除一个注册者
     * @author luoyong
     * @create 11:07 2019/9/22
     * @last modify by [LuoYong 11:07 2019/9/22 ]
     */
    @Override
    public void removeObserver(Observer o) {
        if (observerList.contains(o)) {
            observerList.remove(o);
        }
    }

    /**
     * @param
     * @return void
     * @Description: 通知所有的观察者
     * @author luoyong
     * @create 11:08 2019/9/22
     * @last modify by [LuoYong 11:08 2019/9/22 ]
     */
    @Override
    public void notifyObservers() {
        observerList.forEach(item -> {
            item.update(this.temperature, this.pressure, this.humidity);
        });
    }

    public void dataChange() {
        notifyObservers();
    }

    /**
     * @param temperature
     * @param pressure
     * @param humidity
     * @return void
     * @Description: 当数据更新的时候 就调用setData
     * @author luoyong
     * @create 10:52 2019/9/22
     * @last modify by [LuoYong 10:52 2019/9/22 ]
     */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange， 将最新的信息 推送给 接入方 currentConditions
        dataChange();
    }
}
