package com.ly.senior.designpatterns.jdksource;

import org.junit.Test;

import java.util.Calendar;

/**
 * @author luoyong
 * @Description: 工厂模式jdk源码
 * @create 2019-09-09 23:08
 * @last modify by [LuoYong 2019-09-09 23:08]
 **/
public class Factory {

    /**
     * @param
     * @return void
     * @Description: 工厂模式jdk源码--Calendar
     * @author luoyong
     * @create 23:09 2019/9/9
     * @last modify by [LuoYong 23:09 2019/9/9 ]
     */
    @Test
    public void test() {
        // getInstance 是 Calendar 静态方法
        Calendar cal = Calendar.getInstance();
        // 注意月份下标从0开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));
    }
}
