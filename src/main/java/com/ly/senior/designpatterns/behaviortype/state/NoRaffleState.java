package com.ly.senior.designpatterns.behaviortype.state;

import lombok.Data;

/**
 * @author luoyong
 * @Description: 不能抽奖状态
 * @create 2019-09-22 18:07
 * @last modify by [LuoYong 2019-09-22 18:07]
 **/
@Data
public class NoRaffleState extends State {

    /**
     * 初始化时传入活动引用 扣除积分之后改变其状态
     */
    private RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * @param
     * @return void
     * @Description: 当前状态可以扣积分 , 扣除后，将状态设置成可以抽奖状态
     * @author luoyong
     * @create 18:10 2019/9/22
     * @last modify by [LuoYong 18:10 2019/9/22 ]
     */
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    /**
     * @param
     * @return boolean
     * @Description: 当前状态不能抽奖
     * @author luoyong
     * @create 18:15 2019/9/22
     * @last modify by [LuoYong 18:15 2019/9/22 ]
     */
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖喔！");
        return false;
    }

    /**
     * @param
     * @return void
     * @Description: 当前状态不能发奖品
     * @author luoyong
     * @create 18:16 2019/9/22
     * @last modify by [LuoYong 18:16 2019/9/22 ]
     */
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
