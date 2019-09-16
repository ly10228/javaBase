package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: LightOffCommand
 * @create 2019-09-16 22:49
 * @last modify by [LuoYong 2019-09-16 22:49]
 **/
public class LightOffCommand implements Command {

    private LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        //关灯
        light.off();
    }

    @Override
    public void undo() {
        //开灯
        light.on();
    }
}
