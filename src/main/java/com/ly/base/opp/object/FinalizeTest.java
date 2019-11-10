package com.ly.base.opp.object;

import lombok.Data;
import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-11-10 11:30
 *  * @last modify by [luoyong 2019-11-10 11:30]
 * @Description: FinalizeTest
 **/
public class FinalizeTest {
    @Test
    public void test() {
        Person p = new Person("ly", 26);
        System.out.println(p);
        //此时对象就是垃圾 等待被回收 但是时间不确定
        p = null;
        //强制释放空间
        System.gc();
    }
}


@Data
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * @return void
     * @Description: 子类重写此方法，可在释放对象前进行某些操作
     * @author luoyong
     * @create 11:31 2019-11-10
     * @last modify by [luoyong 11:31 2019-11-10 ]
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象被释放--->" + this);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}