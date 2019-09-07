package com.ly.senior.designpatterns.uml.composition;

/**
 * @author luoyong
 * @Description: Computer
 * @create 2019-09-07 17:10
 * @last modify by [LuoYong 2019-09-07 17:10]
 **/
public class Computer {
    /**
     * 鼠标可以和computer不能分离
     */
    private Mouse mouse = new Mouse();
    /**
     * 显示器可以和Computer不能分离
     */
    private Moniter moniter = new Moniter();

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setMoniter(Moniter moniter) {
        this.moniter = moniter;
    }
}
