package com.ly.senior.designpatterns.behaviortype.memento.theory;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Originator（发起者）
 * @create 2019-09-22 17:14
 * @last modify by [LuoYong 2019-09-22 17:14]
 **/
@Data
public class Originator {
    /**
     * 状态信息
     */
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    //编写一个方法，可以保存一个状态对象 Memento
    //因此编写一个方法，返回 Memento
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    //通过备忘录对象，恢复状态
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

}
