package com.ly.senior.designpatterns.structured.sgg.adapter;

/**
 * @author luoyong
 *  * @create 2021-06-13 9:40 下午
 *  * @last modify by [luoyong 2021-06-13 9:40 下午]
 * @Description: 系统原有接口 player：可以播放电影，并且返回字幕
 **/
public interface Player {
    /**
     * @return java.lang.String
     * @Description: 电影播放返字幕
     * @author luoyong
     * @create 9:41 下午 2021/6/13
     * @last modify by [LuoYong 9:41 下午 2021/6/13 ]
     */
    String play();
}
