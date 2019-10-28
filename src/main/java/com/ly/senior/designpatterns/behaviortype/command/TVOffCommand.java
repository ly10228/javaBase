package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: TVOffCommand
 * @create 2019-09-16 22:55
 * @last modify by [LuoYong 2019-09-16 22:55]
 **/
public class TVOffCommand implements Command {
    /**
     * 聚合TVReceiver
     */
    private TVReceiver tv;

    // 构造器
    public TVOffCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }

}
