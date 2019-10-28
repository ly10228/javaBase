package com.ly.senior.designpatterns.behaviortype.observer.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-22 11:10
 * @last modify by [LuoYong 2019-09-22 11:10]
 **/
public class Client {

    /**
     * @param
     * @return void
     * @Description: 观察者模式测试
     * @author luoyong
     * @create 11:10 2019/9/22
     * @last modify by [LuoYong 11:10 2019/9/22 ]
     */
    @Test
    public void test() {

        WeatherData weatherData = new WeatherData();

        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();

        //注册到weatherData
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);

        //测试
        System.out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);


        weatherData.removeObserver(currentConditions);
        //测试
        System.out.println();
        System.out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);
    }
}
