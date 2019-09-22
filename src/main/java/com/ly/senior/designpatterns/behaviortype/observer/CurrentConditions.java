package com.ly.senior.designpatterns.behaviortype.observer;

import lombok.Data;

/**
 * @author luoyong
 * @Description: 显示当前天气情况 气象站自己的网站
 * @create 2019-09-22 10:44
 * @last modify by [LuoYong 2019-09-22 10:44]
 **/
@Data
public class CurrentConditions {

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
     * @param temperature
     * @param pressure
     * @param humidity
     * @return void
     * @Description: 更新天气情况 是由 WeatherData 来调用，我使用推送模式
     * @author luoyong
     * @create 10:48 2019/9/22
     * @last modify by [LuoYong 10:48 2019/9/22 ]
     */
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.display();
    }

    public void display() {
        System.out.println("***Today mTemperature: " + temperature + "***");
        System.out.println("***Today mPressure: " + pressure + "***");
        System.out.println("***Today mHumidity: " + humidity + "***");
    }

}
