package com.ly.base.opp.threecharacteristics.abstraction.exer2;

import lombok.Data;

/**
 * @author luoyong
 * @Description: MyDate
 * @create 2019-11-18 21:37
 * @last modify by [LuoYong 2019-11-18 21:37]
 **/
@Data
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toDateString() {
        return year + "年" + month + "月" + day + "日";
    }
}
