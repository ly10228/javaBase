package com.ly.senior.designpatterns.structured.adapter.classadapter;

/**
 * @author luoyong
 * @Description: 被适配的类 输出220V电压
 * @create 2019-09-14 9:39
 * @last modify by [LuoYong 2019-09-14 9:39]
 **/
public class Voltage220V {
    /**
     * @param
     * @return int
     * @Description: 输出220V
     * @author luoyong
     * @create 9:41 2019/9/14
     * @last modify by [LuoYong 9:41 2019/9/14 ]
     */
    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
