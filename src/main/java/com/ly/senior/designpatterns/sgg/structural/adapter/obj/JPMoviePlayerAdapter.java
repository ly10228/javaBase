package com.ly.senior.designpatterns.sgg.structural.adapter.obj;

import com.ly.senior.designpatterns.sgg.structural.adapter.Player;
import com.ly.senior.designpatterns.sgg.structural.adapter.Translator;

/**
 * @author luoyong
 *  * @create 2021-06-13 9:50 下午
 *  * @last modify by [luoyong 2021-06-13 9:50 下午]
 * @Description: 继承的方式：类结构模型，适配转换到了翻译器的功能上
 **/
public class JPMoviePlayerAdapter implements Player {

    //被适配对象
    private Player target;

    //组合
    private Translator translate;

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public Translator getTranslate() {
        return translate;
    }

    public void setTranslate(Translator translate) {
        this.translate = translate;
    }

    @Override
    public String play() {
        //被适配对象播放的内容
        String playContent = target.play();
        //转换成要想的字幕
        String translateContent = translate.translate(playContent);
        System.out.println(translateContent);
        return translateContent;
    }
}
