package com.ly.senior.designpatterns.behaviortype.command;

/**
 * @author luoyong
 * @Description: RemoteController
 * @create 2019-09-16 22:58
 * @last modify by [LuoYong 2019-09-16 22:58]
 **/
public class RemoteController {
    /**
     * 开 按钮的命令数组
     */
    Command[] onCommands;
    Command[] offCommands;

    /**
     * 执行撤销命令
     */
    Command undoCommand;

    /**
     * 构造器 完成对按钮的初始化
     */
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    /**
     * @param no
     * @param onCommand
     * @param offCommand
     * @return void
     * @Description: 给按钮设置你需要执行的命令
     * @author luoyong
     * @create 23:01 2019/9/16
     * @last modify by [LuoYong 23:01 2019/9/16 ]
     */
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    /**
     * @param no
     * @return void
     * @Description: 按下开按钮
     * @author luoyong
     * @create 23:02 2019/9/16
     * @last modify by [LuoYong 23:02 2019/9/16 ]
     */
    public void onButtonWasPushed(int no) {
        // 找到你按下的开的按钮， 并调用对应方法
        onCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    /**
     * @param no
     * @return void
     * @Description: 按下关按钮
     * @author luoyong
     * @create 23:05 2019/9/16
     * @last modify by [LuoYong 23:05 2019/9/16 ]
     */
    public void offButtonWasPushed(int no) { // no 0
        // 找到你按下的关的按钮， 并调用对应方法
        offCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = offCommands[no];

    }

    /**
     * @param
     * @return void
     * @Description: 按下撤销按钮
     * @author luoyong
     * @create 23:06 2019/9/16
     * @last modify by [LuoYong 23:06 2019/9/16 ]
     */
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }


}
