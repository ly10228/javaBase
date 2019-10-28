package com.ly.senior.designpatterns.behaviortype.memento.theory;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author luoyong
 * @Description: Caretaker
 * @create 2019-09-22 17:33
 * @last modify by [LuoYong 2019-09-22 17:33]
 **/
public class Caretaker {

    /**
     * 在List 集合中会有很多的备忘录对象
     */
    private List<Memento> mementoList = Lists.newArrayList();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    /**
     * @param index
     * @return
     * @Description: 获取到第index个Originator 的 备忘录对象(即保存状态)
     * @author luoyong
     * @create 17:34 2019/9/22
     * @last modify by [LuoYong 17:34 2019/9/22 ]
     */
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
