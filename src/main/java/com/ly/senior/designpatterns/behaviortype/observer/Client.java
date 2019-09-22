package com.ly.senior.designpatterns.behaviortype.observer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-22 10:53
 * @last modify by [LuoYong 2019-09-22 10:53]
 **/
public class Client {

    @Test
    public void test() {
        //创建接入方 currentConditions
        CurrentConditions currentConditions = new CurrentConditions();
        //创建 WeatherData 并将 接入方 currentConditions 传递到 WeatherData中
        WeatherData weatherData = new WeatherData(currentConditions);

        //更新天气情况
        weatherData.setData(30, 150, 40);

        //天气情况变化
        System.out.println("============天气情况变化=============");
        weatherData.setData(40, 160, 20);
    }
}
