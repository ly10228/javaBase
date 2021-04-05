package com.ly.senior.juc.chaincall;

/**
 * @author luoyong
 *  * @create 2021-04-05 11:45 上午
 *  * @last modify by [luoyong 2021-04-05 11:45 上午]
 * @Description: 链式调用测试
 **/
public class ChainCallTest {
    public static void main(String[] args) {
        //传统写法
        Book book = new Book();
//        book.setId(1);
//        book.setBookName("java");
//        book.setAuthor("tom");
//        book.setPrice(25.7);

        //链式写法
        book.setId(1).setBookName("java").setAuthor("tim").setPrice(22.8);
    }
}
