package com.ly.senior.jvm.bytecode.analysis;

/**
 * @author luoyong
 *  * @create 2021-05-15 2:25 下午
 *  * @last modify by [luoyong 2021-05-15 2:25 下午]
 * @Description: JavapTest
 **/
public class JavapTest {
    private int num;
    boolean flag;
    protected char gender;
    public String info;

    public static final int COUNTS = 1;

    static {
        String url = "www.ly";
    }

    {
        info = "java";
    }

    public JavapTest() {

    }

    private JavapTest(boolean flag) {
        this.flag = flag;
    }

    private void methodPrivate() {

    }

    int getNum(int i) {
        return num + i;
    }

    protected char showGender() {
        return gender;
    }

    public void showInfo() {
        int i = 10;
        System.out.println(info + i);
    }
}
