package com.ly.senior.designpatterns.structured.adapter.objectadapter;

import com.ly.senior.designpatterns.structured.adapter.classadapter.IVoltage5V;
import com.ly.senior.designpatterns.structured.adapter.classadapter.Voltage220V;

/**
 * @author luoyong
 * @Description: 适配器类--具体实现转换
 * @create 2019-09-14 9:42
 * @last modify by [LuoYong 2019-09-14 9:42]
 **/
public class VoltageAdapter implements IVoltage5V {

    /**
     * 聚合220v电源
     */
    private Voltage220V voltage220V;

    /**
     * 通过构造器注入Voltage220V实例
     *
     * @param voltage220V
     */
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    /**
     * @param
     * @return int
     * @Description: 将220V转换成5V
     * @author luoyong
     * @create 9:44 2019/9/14
     * @last modify by [LuoYong 9:44 2019/9/14 ]
     */
    @Override
    public int output5V() {
        int dstV = 0;
        if (null != voltage220V) {
            int srcV = voltage220V.output220V();
            //转换成5V
            dstV = srcV / 44;
            System.out.println("适配完成，输出的电压为=" + dstV);
        }

        return dstV;
    }
}
