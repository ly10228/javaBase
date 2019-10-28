package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: NoCommand
 * 没有任何命令，即空执行 用于初始化每个按钮 当调用空命令时，对象什么都不做
 * 其实这也是一种设计模式，可以省略对空的判断
 * @create 2019-09-16 22:53
 * @last modify by [LuoYong 2019-09-16 22:53]
 **/
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
