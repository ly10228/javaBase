package com.ly.senior.designpatterns.principle.inversion.improve.pass;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: DependencyPassByConstruction
 * 构造方法
 * @create 2019-08-29 23:47
 * @last modify by [LuoYong 2019-08-29 23:47]
 **/
public class DependencyPassByConstruction {

    /**
     * @param
     * @return void
     * @Description: 测试构造方法依赖
     * @author luoyong
     * @create 23:57 2019/8/29
     * @last modify by [LuoYong 23:57 2019/8/29 ]
     */
    @Test
    public void test() {
        ChangHongConstruction changHongConstruction = new ChangHongConstruction();
        OpenAndCloseConstruction openAndCloseConstruction = new OpenAndCloseConstruction(changHongConstruction);
        openAndCloseConstruction.open();
    }
}

/**
 * 电视显示接口
 */
interface ITVConstruction {
    void open();
}

class ChangHongConstruction implements ITVConstruction {
    @Override
    public void open() {
        System.out.println("长虹电视机,打开");
    }
}

interface IOpenAndCloseConstruction {
    void open();
}

class OpenAndCloseConstruction implements IOpenAndCloseConstruction {
    //构造方法依赖
    private ITVConstruction itvConstruction;

    public OpenAndCloseConstruction(ITVConstruction itvConstruction) {
        this.itvConstruction = itvConstruction;
    }

    @Override
    public void open() {
        itvConstruction.open();
    }
}
