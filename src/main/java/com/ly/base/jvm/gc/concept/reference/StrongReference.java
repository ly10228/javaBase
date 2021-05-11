package com.ly.base.jvm.gc.concept.reference;

/**
 * @author luoyong
 *  * @create 2021-02-25 10:46 上午
 *  * @last modify by [luoyong 2021-02-25 10:46 上午]
 * @Description: 强引用
 **/
public class StrongReference {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello ly");
        StringBuffer str1 = str;
        str = null;
        System.gc();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(str1);
    }
}
