package com.ly.ec;

/**
 * @author luoyong
 *  * @create 2020-05-16 11:27 上午
 *  * @last modify by [luoyong 2020-05-16 11:27 上午]
 * @Description: TODO
 **/
public class HasStatic {
    private static int x = 100;

    public static void main(String args[]) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);
    }
}
