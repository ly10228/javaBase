package com.ly.senior.designpatterns.behaviortype.observer;

import lombok.Data;

/**
 * @author luoyong
 * @Description: WeatherData
 * 1:  包含最新的天气情况信息
 * 2:  含有 CurrentConditions 对象
 * 3:  当数据有更新时，就主动的调用   CurrentConditions对象update方法(含 display), 这样他们（接入方）就看到最新的信息
 * @create 2019-09-22 10:49
 * @last modify by [LuoYong 2019-09-22 10:49]
 **/
@Data
public class WeatherData {

    private float temperature;

    private float pressure;

    private float humidity;

    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public void dataChange() {
        currentConditions.update(getTemperature(), getPressure(), getHumidity());
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
