package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: LightOnCommand--开灯
 * @create 2019-09-16 22:52
 * @last modify by [LuoYong 2019-09-16 22:52]
 **/
public class LightOnCommand implements Command {
    private LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        //开灯
        light.on();
    }

    @Override
    public void undo() {
        //关灯
        light.off();
    }
}
