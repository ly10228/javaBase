package com.ly.base.opp.threecharacteristics.abstraction.exer;

/**
 * @author luoyong
 * @Description: Manager
 * @create 2019-11-16 22:08
 * @last modify by [LuoYong 2019-11-16 22:08]
 **/
public class Manager extends Employee {

    /**
     * 奖金
     */
    private double bonus;


    public Manager(double bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理员工，提供公司运行的效率");
    }
}
