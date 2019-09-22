package com.ly.senior.designpatterns.behaviortype.state;

/**
 * @author luoyong
 * @Description: State
 * @create 2019-09-22 18:06
 * @last modify by [LuoYong 2019-09-22 18:06]
 **/
public abstract class State {

    /**
     * @param
     * @return void
     * @Description: 扣除积分 - 50
     * @author luoyong
     * @create 18:06 2019/9/22
     * @last modify by [LuoYong 18:06 2019/9/22 ]
     */
    public abstract void deductMoney();

    /**
     * @param
     * @return boolean
     * @Description: 是否抽中奖品
     * @author luoyong
     * @create 18:07 2019/9/22
     * @last modify by [LuoYong 18:07 2019/9/22 ]
     */
    public abstract boolean raffle();

    /**
     * @param
     * @return void
     * @Description: 发放奖品
     * @author luoyong
     * @create 18:07 2019/9/22
     * @last modify by [LuoYong 18:07 2019/9/22 ]
     */
    public abstract void dispensePrize();
}
