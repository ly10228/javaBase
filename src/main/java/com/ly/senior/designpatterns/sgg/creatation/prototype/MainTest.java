package com.ly.senior.designpatterns.sgg.creatation.prototype;

/**
 * @author luoyong
 *  * @create 2021-06-14 2:56 下午
 *  * @last modify by [luoyong 2021-06-14 2:56 下午]
 * @Description: 测试
 * 是用于创建重复的对象，同时又能保证性能。-->同时对本体不产生影响
 * 1、MybatisUtils：操作数据库，从数据库里面查出很多记录（70%改变很少）
 * 2、每次查数据库，查到以后把所有数据都封装一个对象，返回。
 * 10000 thread：查一个记录： new User("zs",18)；每次创建一个对象封装并返回
 * 系统里面就会有10000个User;浪费内存
 * 3、解决：缓存；查过的保存。
 * 如果再查相同的记录，拿到原来的原型对象
 * 4、此时直接拿到缓存中的对象。
 **/
public class MainTest {
    public static void main(String[] args) throws Exception {
        MybatisUtils mybatis = new MybatisUtils();

        //十分危险
        //得到的是克隆体
        User zs1 = mybatis.getUser("zs");
        System.out.println("1==>" + zs1);
        zs1.setUsername("ls001");
        System.out.println("zs1自己改了：" + zs1);


        //得到的是克隆体
        User zs2 = mybatis.getUser("zs");

        System.out.println("2-->" + zs2);

        //得到的是克隆体
        User zs3 = mybatis.getUser("zs");
        System.out.println("3-->" + zs3);

        //得到的是克隆体
        User zs4 = mybatis.getUser("zs");
        System.out.println("4-->" + zs4);

        //false
        System.out.println(zs1 == zs2);

    }
}
