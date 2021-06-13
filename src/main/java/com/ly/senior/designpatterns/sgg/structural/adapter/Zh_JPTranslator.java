package com.ly.senior.designpatterns.sgg.structural.adapter;

/**
 * @author luoyong
 *  * @create 2021-06-13 9:47 下午
 *  * @last modify by [luoyong 2021-06-13 9:47 下午]
 * @Description: ZH_JP翻译器 ZH_EN翻译器 ......
 **/
public class Zh_JPTranslator implements Translator {
    @Override
    public String translate(String content) {
        if ("你好".equals(content)) {
            return "空尼几哇";
        }
        if ("什么".equals(content)) {
            return "纳尼";
        }
        return "*******";
    }
}
