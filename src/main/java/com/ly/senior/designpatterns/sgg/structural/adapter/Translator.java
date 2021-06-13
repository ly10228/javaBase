package com.ly.senior.designpatterns.sgg.structural.adapter;

/**
 * @author luoyong
 *  * @create 2021-06-13 9:45 下午
 *  * @last modify by [luoyong 2021-06-13 9:45 下午]
 * @Description: 2、系统原有接口，可以翻译文字内容
 **/
public interface Translator {
    /**
     * @param content
     * @return
     * @Description: 将输入的内容翻译成指定的语言 并返回
     * @author luoyong
     * @create 9:46 下午 2021/6/13
     * @last modify by [LuoYong 9:46 下午 2021/6/13 ]
     */
    String translate(String content);
}
