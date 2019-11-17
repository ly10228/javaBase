package com.ly.base.opp.threecharacteristics.abstraction.exer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: 抽象类的应用：模板方法的设计模式
 * @create 2019-11-17 9:32
 * @last modify by [LuoYong 2019-11-17 9:32]
 **/
public class TemplateTest {

    @Test
    public void test() {
        //多态
        Template template = new SubTemplate();
        template.spendTime();
    }
}

abstract class Template {

    /**
     * @param
     * @return void
     * @Description: 计算某段代码执行所需要花费的时间
     * @author luoyong
     * @create 9:33 2019/11/17
     * @last modify by [LuoYong 9:33 2019/11/17 ]
     */
    public void spendTime() {
        //开始时间
        long startTime = System.currentTimeMillis();
        code();
        //结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("花费的时间为:" + (endTime - startTime) + "ms");
    }

    public abstract void code();
}


class SubTemplate extends Template {
    @Override
    public void code() {
        for (int i = 2; i <= 1000; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {

                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}