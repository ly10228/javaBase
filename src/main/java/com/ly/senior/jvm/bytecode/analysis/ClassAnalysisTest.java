package com.ly.senior.jvm.bytecode.analysis;

/**
 * @author luoyong
 *  * @create 2021-05-15 9:41 上午
 *  * @last modify by [luoyong 2021-05-15 9:41 上午]
 * @Description: ClassAnalysisTest
 **/
public class ClassAnalysisTest {
    private int num = 1;

    public int add() {
        num = num + 2;
        return num;

    }
}
