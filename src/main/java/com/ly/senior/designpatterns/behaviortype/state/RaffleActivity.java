package com.ly.senior.designpatterns.behaviortype.state;

import lombok.Data;

/**
 * @author luoyong
 * @Description: 抽奖活动
 * @create 2019-09-22 18:08
 * @last modify by [LuoYong 2019-09-22 18:08]
 **/
@Data
public class RaffleActivity {

    /**
     * state 表示活动当前的状态，是变化
     */
    State state = null;

    /**
     * 奖品数量
     */
    int count = 0;

    /**
     * 四个属性 表示四种撞他与
     */
    State noRafflleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);

    State dispenseState = new DispenseState(this);
    State dispensOutState = new DispenseOutState(this);

    /**
     * @param count
     * @return
     * @Description: 构造器
     * 1. 初始化当前的状态为 noRafflleState（即不能抽奖的状态）
     * 2. 初始化奖品的数量
     * @author luoyong
     * @create 18:14 2019/9/22
     * @last modify by [LuoYong 18:14 2019/9/22 ]
     */
    public RaffleActivity(int count) {
        this.state = getNoRafflleState();
        this.count = count;
    }


    /**
     * @param
     * @return void
     * @Description: 扣分, 调用当前状态的 deductMoney
     * @author luoyong
     * @create 18:11 2019/9/22
     * @last modify by [LuoYong 18:11 2019/9/22 ]
     */
    public void debuctMoney() {
        state.deductMoney();
    }

    /**
     * @param
     * @return void
     * @Description: 抽奖
     * @author luoyong
     * @create 18:12 2019/9/22
     * @last modify by [LuoYong 18:12 2019/9/22 ]
     */
    public void raffle() {
        // 如果当前的状态是抽奖成功
        if (state.raffle()) {
            //领取奖品
            state.dispensePrize();
        }

    }

    /**
     * @param
     * @return int
     * @Description: 每领取一次奖品，count--
     * @author luoyong
     * @create 18:12 2019/9/22
     * @last modify by [LuoYong 18:12 2019/9/22 ]
     */
    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

}
