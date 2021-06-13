package com.ly.senior.designpatterns.sgg.structural.adapter.obj;

import com.ly.senior.designpatterns.sgg.structural.adapter.MoviePlayer;
import com.ly.senior.designpatterns.sgg.structural.adapter.Player;
import com.ly.senior.designpatterns.sgg.structural.adapter.Translator;
import com.ly.senior.designpatterns.sgg.structural.adapter.Zh_JPTranslator;

/**
 * @author luoyong
 *  * @create 2021-06-13 9:52 下午
 *  * @last modify by [luoyong 2021-06-13 9:52 下午]
 * @Description: 测试
 **/
public class MainTest {
    public static void main(String[] args) {
        //目标对象
        Player target = new MoviePlayer();

        Translator translator = new Zh_JPTranslator();
        //适配器
        JPMoviePlayerAdapter jpMoviePlayerAdapter = new JPMoviePlayerAdapter();
        jpMoviePlayerAdapter.setTarget(target);
        jpMoviePlayerAdapter.setTranslate(translator);

        jpMoviePlayerAdapter.play();
    }
}
