package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: TVOnCommand
 * @create 2019-09-16 22:56
 * @last modify by [LuoYong 2019-09-16 22:56]
 **/
public class TVOnCommand implements Command {
    /**
     * 聚合TVReceiver
     */
    private TVReceiver tv;

    // 构造器
    public TVOnCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
