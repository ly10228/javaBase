package com.ly.base.opp.encapsulation;

/**
 * @author luoyong
 * @Description: Order
 * @create 2019-10-13 16:39
 * @last modify by [LuoYong 2019-10-13 16:39]
 **/
public class Order {
    private int orderPrivate;

    int orderDefault;

    public int orderPublic;


    private void methodPrivate() {
        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }

    void methodDefault() {
        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }

    public void methodPublic() {
        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }

}
