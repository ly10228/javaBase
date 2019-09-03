package com.ly.senior.designpatterns.principle.inversion.improve.pass;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: DependencyPassByInterface 依赖传递三种方式
 * 1：通过接口传递实现依赖
 * 2：构造器
 * 3：通过setter方法传递
 * @create 2019-08-29 23:45
 * @last modify by [LuoYong 2019-08-29 23:45]
 **/
public class DependencyPassByInterface {

    /**
     * @param
     * @return void
     * @Description: 通过接口传递依赖
     * @author luoyong
     * @create 23:53 2019/8/29
     * @last modify by [LuoYong 23:53 2019/8/29 ]
     */
    @Test
    public void test() {
        ChangHong changHong = new ChangHong();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(changHong);
    }
}

/**
 * 电视显示接口
 */
interface ITV {
    void open();
}

class ChangHong implements ITV {
    @Override
    public void open() {
        System.out.println("长虹电视机,打开");
    }
}

interface IOpenAndClose {
    //通过接口依赖
    void open(ITV itv);
}

class OpenAndClose implements IOpenAndClose {
    @Override
    public void open(ITV itv) {
        itv.open();
    }
}








