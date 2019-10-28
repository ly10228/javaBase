package com.ly.senior.designpatterns.behaviortype.memento.game;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-22 17:21
 * @last modify by [LuoYong 2019-09-22 17:21]
 **/
public class Client {

    @Test
    public void test() {
        //创建游戏角色
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);

        System.out.println("和boss大战前的状态");
        gameRole.display();

        //把当前状态保存caretaker
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("和boss大战~~~");
        gameRole.setDef(30);
        gameRole.setVit(30);

        gameRole.display();

        System.out.println("大战后，使用备忘录对象恢复到站前");

        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        System.out.println("恢复后的状态");
        gameRole.display();
    }
}
