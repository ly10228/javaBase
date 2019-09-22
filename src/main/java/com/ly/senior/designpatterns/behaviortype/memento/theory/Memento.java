package com.ly.senior.designpatterns.behaviortype.memento.theory;

/**
 * @author luoyong
 * @Description: Memento
 * @create 2019-09-22 17:32
 * @last modify by [LuoYong 2019-09-22 17:32]
 **/
public class Memento {
    private String state;

    public Memento(String state) {
        super();
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
