package com.ly.senior.designpatterns.structured.sgg.adapter.clazz;

import com.ly.senior.designpatterns.structured.sgg.adapter.MoviePlayer;

/**
 * @author luoyong
 *  * @create 2021-06-13 9:52 下午
 *  * @last modify by [luoyong 2021-06-13 9:52 下午]
 * @Description: 测试
 **/
public class MainTest {
    public static void main(String[] args) {
        //目标对象
        MoviePlayer target = new MoviePlayer();
        //适配器
        JPMoviePlayerAdapter jpMoviePlayerAdapter = new JPMoviePlayerAdapter(target);
        jpMoviePlayerAdapter.play();
    }
}
