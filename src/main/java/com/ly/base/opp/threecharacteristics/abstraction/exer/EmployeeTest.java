package com.ly.base.opp.threecharacteristics.abstraction.exer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: EmployeeTest
 * @create 2019-11-16 22:10
 * @last modify by [LuoYong 2019-11-16 22:10]
 **/
public class EmployeeTest {

    @Test
    public void test() {
        //多态
        Employee manager = new Manager("库克", 1001, 5000, 50000);

        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}
