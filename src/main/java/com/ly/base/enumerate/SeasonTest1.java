package com.ly.base.enumerate;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author luoyong
 *  * @create 2019-12-08 20:04
 *  * @last modify by [luoyong 2019-12-08 20:04]
 * @Description: SeasonTest1
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 **/
public class SeasonTest1 {

    @Test
    public void test() {
        Season1 summer = Season1.SUMMER;
        //SUMMER
        System.out.println(summer);
        //class java.lang.Enum
        System.out.println(Season1.class.getSuperclass());
    }


    @Test
    public void testValues() {
        Season1[] values = Season1.values();
        //SPRING
        //SUMMER
        //AUTUMN
        //WINTER
        //返回所有的枚举类对象构成的数组
        Arrays.stream(values).forEach(System.out::println);

        Thread.State[] states = Thread.State.values();
        Arrays.stream(states).forEach(System.out::println);
    }


    @Test
    public void testValueOf() {
        //返回枚举类中对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }

}

interface Info {
    void show();
}

enum Season1 implements Info {
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}