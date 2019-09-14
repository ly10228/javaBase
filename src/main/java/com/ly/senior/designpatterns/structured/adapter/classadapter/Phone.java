package com.ly.senior.designpatterns.structured.adapter.classadapter;

/**
 * @author luoyong
 * @Description: Phone 对于充电限制
 * 缺点：
 * 1：java是单继承机制，所以类适配器需要继承src类这一点是一个缺点，因为这要求dst必须是接口，有一定的局限性。
 * 2：src类的方法在Adapter中都
 * 会暴露出来，也增加了使用的成本
 * 优点：由于继承了src类，所以他可以根据需求重写src类的方法，使得Adapter的灵活性增强了
 * @create 2019-09-14 9:46
 * @last modify by [LuoYong 2019-09-14 9:46]
 **/
public class Phone {
    /**
     * @param iVoltage5V
     * @return void
     * @Description: 对于充电限制 等于5V的时候才可以充电
     * @author luoyong
     * @create 9:47 2019/9/14
     * @last modify by [LuoYong 9:47 2019/9/14 ]
     */
    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压为5V, 可以充电~~");
        } else if (iVoltage5V.output5V() > 5) {
            System.out.println("电压大于5V, 不能充电~~");
        }
    }
}
