package com.ly.senior.designpatterns.behaviortype.memento.game;

/**
 * @author luoyong
 * @Description: Caretaker 守护者对象, 保存游戏角色的状态
 * @create 2019-09-22 17:20
 * @last modify by [LuoYong 2019-09-22 17:20]
 **/
public class Caretaker {

    /**
     * 如果只保存一次状态
     * 对GameRole 保存多次状态
     * private List<Memento> mementos;
     * 对多个游戏角色保存多个状态
     * private HashMap<String, ArrayList<Memento>> rolesMementos;
     */
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
