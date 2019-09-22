package com.ly.senior.designpatterns.behaviortype.memento.game;

import lombok.Data;

/**
 * @author luoyong
 * @Description: GameRole
 * @create 2019-09-22 17:17
 * @last modify by [LuoYong 2019-09-22 17:17]
 **/
@Data
public class GameRole {

    private int vit;

    private int def;

    /**
     * @param
     * @return
     * @Description: 创建Memento ,即根据当前的状态得到Memento
     * @author luoyong
     * @create 17:17 2019/9/22
     * @last modify by [LuoYong 17:17 2019/9/22 ]
     */
    public Memento createMemento() {
        return new Memento(vit, def);
    }

    /**
     * @param memento
     * @return void
     * @Description: 从备忘录对象，恢复GameRole的状态
     * @author luoyong
     * @create 17:19 2019/9/22
     * @last modify by [LuoYong 17:19 2019/9/22 ]
     */
    public void recoverGameRoleFromMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    /**
     * @param
     * @return void
     * @Description: 显示当前游戏角色的状态
     * @author luoyong
     * @create 17:19 2019/9/22
     * @last modify by [LuoYong 17:19 2019/9/22 ]
     */
    public void display() {
        System.out.println("游戏角色当前的攻击力：" + this.vit + " 防御力: " + this.def);
    }


}
