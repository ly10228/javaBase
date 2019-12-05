package com.ly.base.opp.object;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-11-10 11:42
 *  * @last modify by [luoyong 2019-11-10 11:42]
 * @Description: CloneTest
 **/
public class CloneTest {
    @Test
    public void test() {
        Animal a1 = new Animal("花花");
        try {
            Animal a2 = (Animal) a1.clone();
            System.out.println("原始对象：" + a1);
            a2.setName("毛毛");
            System.out.println("clone之后的对象：" + a2);
            System.out.println("被克隆的对象是" + a1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

@Getter
@Setter
class Animal implements Cloneable {
    private String name;

    public Animal() {
        super();
    }

    public Animal(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
}