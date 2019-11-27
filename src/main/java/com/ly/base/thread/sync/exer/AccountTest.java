package com.ly.base.thread.sync.exer;

/**
 * @author luoyong
 * @Description: AccountTest
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * 分析：
 * 1.是否是多线程问题？ 是，两个储户线程
 * 2.是否有共享数据？ 有，账户（或账户余额）
 * 3.是否有线程安全问题？有
 * 4.需要考虑如何解决线程安全问题？同步机制：有三种方式。
 * @create 2019-11-27 23:59
 * @last modify by [LuoYong 2019-11-27 23:59]
 **/
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        User t1 = new User(account);
        User t2 = new User(account);

        t1.setName("用户A");
        t2.setName("用户B");
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}

class Account {

    /**
     * 余额
     */
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * @param
     * @return void
     * @Description: 存钱
     * @author luoyong
     * @create 0:01 2019/11/28
     * @last modify by [LuoYong 0:01 2019/11/28 ]
     */
    public synchronized void saveMoney(double amount) {
        if (amount <= 0) {
            return;
        }
        balance += amount;

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为:" + balance);
    }
}


class User extends Thread {
    /**
     * 用户账户信息
     */
    private Account account;

    public User(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.saveMoney(1000);
        }
    }
}