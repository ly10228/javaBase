package com.ly.senior.designpatterns.sgg.structural.adapter;

/**
 * @author luoyong
 *  * @create 2021-06-13 9:41 下午
 *  * @last modify by [luoyong 2021-06-13 9:41 下午]
 * @Description: 电影播放器
 **/
public class MoviePlayer implements Player {

    /**
     * @return java.lang.String
     * @Description: 电影播放器 返回中文字幕
     * @author luoyong
     * @create 9:42 下午 2021/6/13
     * @last modify by [LuoYong 9:42 下午 2021/6/13 ]
     */
    @Override
    public String play() {
        System.out.println("正在播放：宋老师的宝贵时间.avi");
        String content = "你好";
        //并且打印出字幕
        System.out.println(content);
        return content;
    }
}
