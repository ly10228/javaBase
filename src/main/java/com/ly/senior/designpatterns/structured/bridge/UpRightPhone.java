package com.ly.senior.designpatterns.structured.bridge;

/**
 * @author luoyong
 * @Description: UpRightPhone
 * @create 2019-09-14 16:37
 * @last modify by [LuoYong 2019-09-14 16:37]
 **/
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println(" 直立样式手机 ");
    }

    public void close() {
        super.close();
        System.out.println(" 直立样式手机 ");
    }

    public void call() {
        super.call();
        System.out.println(" 直立样式手机 ");
    }

}
