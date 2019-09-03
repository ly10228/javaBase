package com.ly.senior.designpatterns.principle.inversion.improve.pass;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: DependencyPassBySetter
 * Setter
 * @create 2019-08-29 23:48
 * @last modify by [LuoYong 2019-08-29 23:48]
 **/
public class DependencyPassBySetter {

    /**
     * @param
     * @return void
     * @Description: 测setter传递依赖
     * @author luoyong
     * @create 0:03 2019/8/30
     * @last modify by [LuoYong 0:03 2019/8/30 ]
     */
    @Test
    public void test() {
        OpenAndCloseSetter openAndCloseSetter = new OpenAndCloseSetter();
        //setter传递依赖
        openAndCloseSetter.set(new ChangHongVSetter());
        openAndCloseSetter.open();
    }
}


/**
 * 电视显示接口
 */
interface ITVSetter {
    void open();
}

class ChangHongVSetter implements ITVSetter {
    @Override
    public void open() {
        System.out.println("长虹电视机,打开");
    }
}

interface IOpenAndCloseSetter {
    void open();

    //setter方法
    void set(ITVSetter itvSetter);
}

class OpenAndCloseSetter implements IOpenAndCloseSetter {
    //构造方法依赖
    private ITVSetter itvSetter;

    @Override
    public void set(ITVSetter itvSetter) {
        this.itvSetter = itvSetter;
    }

    @Override
    public void open() {
        itvSetter.open();
    }
}
