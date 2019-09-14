package com.ly.senior.designpatterns.structured.adapter.classadapter;

/**
 * @author luoyong
 * @Description: 适配器类--具体实现转换
 * @create 2019-09-14 9:42
 * @last modify by [LuoYong 2019-09-14 9:42]
 **/
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

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
        int srcV = output220V();
        //转换成5V
        int dstV = srcV / 44;
        return dstV;
    }
}
