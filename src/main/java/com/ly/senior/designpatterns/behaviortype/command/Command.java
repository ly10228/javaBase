package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: Command
 * @create 2019-09-16 22:47
 * @last modify by [LuoYong 2019-09-16 22:47]
 **/
public interface Command {

    /**
     * @param
     * @return void
     * @Description: 执行动作--操作
     * @author luoyong
     * @create 22:48 2019/9/16
     * @last modify by [LuoYong 22:48 2019/9/16 ]
     */
    void execute();

    /**
     * 撤销动作（操作）
     */
    void undo();
}
