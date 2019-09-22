package com.ly.senior.designpatterns.behaviortype.observer.improve;

import lombok.Data;

/**
 * @author luoyong
 * @Description: BaiduSite
 * @create 2019-09-22 11:00
 * @last modify by [LuoYong 2019-09-22 11:00]
 **/
@Data
public class BaiduSite implements Observer {
    /**
     * 温度，气压，湿度
     */
    private float temperature;
    private float pressure;
    private float humidity;

    /**
     * @param temperature
     * @param pressure
     * @param humidity
     * @return void
     * @Description: 更新 天气情况，是由 WeatherData 来调用，我使用推送模式
     * @author luoyong
     * @create 11:01 2019/9/22
     * @last modify by [LuoYong 11:01 2019/9/22 ]
     */
    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    /**
     * @param
     * @return void
     * @Description: 显示
     * @author luoyong
     * @create 11:00 2019/9/22
     * @last modify by [LuoYong 11:00 2019/9/22 ]
     */
    public void display() {
        System.out.println("===百度网站====");
        System.out.println("***百度网站 气温 : " + temperature + "***");
        System.out.println("***百度网站 气压: " + pressure + "***");
    }
}
