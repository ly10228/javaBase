package com.ly.base.opp.threecharacteristics.abstraction.exer2;

import lombok.Getter;
import lombok.Setter;

/**
 * @author luoyong
 * @Description: HourlyEmployee
 * @create 2019-11-18 21:41
 * @last modify by [LuoYong 2019-11-18 21:41]
 **/
@Getter
@Setter
public class HourlyEmployee extends Employee {

    /**
     * 每小时的工资
     */
    private int wage;

    /**
     * 月工作的小时数
     */
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }


    @Override
    public double earnings() {
        return wage * hour;
    }


    public String toString() {
        return "HourlyEmployee[" + super.toString() + "]";
    }

}
