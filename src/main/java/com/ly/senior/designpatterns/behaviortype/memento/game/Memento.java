package com.ly.senior.designpatterns.behaviortype.memento.game;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Memento（纪念品 备忘录）
 * @create 2019-09-22 17:15
 * @last modify by [LuoYong 2019-09-22 17:15]
 **/
@Data
public class Memento {

    /**
     * 攻击力
     */
    private int vit;

    /**
     * 防御力
     */
    private int def;

    public Memento(int vit, int def) {
        super();
        this.vit = vit;
        this.def = def;
    }
}
