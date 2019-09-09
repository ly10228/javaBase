package com.ly.senior.designpatterns.creational.factory.tradition.pizza;

/**
 * @author luoyong
 * @Description: Pizza
 * @create 2019-09-08 22:23
 * @last modify by [LuoYong 2019-09-08 22:23]
 **/
public abstract class Pizza {
    /**
     * 名字
     */
    protected String name;

    /**
     * 准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
     */
    public abstract void prepare();


    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    /**
     * 打包
     */
    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
