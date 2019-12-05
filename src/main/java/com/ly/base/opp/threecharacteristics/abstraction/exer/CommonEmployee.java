package com.ly.base.opp.threecharacteristics.abstraction.exer;

/**
 * @author luoyong
 * @Description: CommonEmployee
 * @create 2019-11-16 22:09
 * @last modify by [LuoYong 2019-11-16 22:09]
 **/
public class CommonEmployee extends Employee {
    @Override
    public void work() {
        System.out.println("员工在一线车间生产产品");
    }
}
