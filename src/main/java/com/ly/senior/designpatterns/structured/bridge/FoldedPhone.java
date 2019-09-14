package com.ly.senior.designpatterns.structured.bridge;

/**
 * @author luoyong
 * @Description: FoldedPhone
 * @create 2019-09-14 16:36
 * @last modify by [LuoYong 2019-09-14 16:36]
 **/
public class FoldedPhone extends Phone {
    //构造器
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println(" 折叠样式手机 ");
    }

    public void close() {
        super.close();
        System.out.println(" 折叠样式手机 ");
    }

    public void call() {
        super.call();
        System.out.println(" 折叠样式手机 ");
    }
}
