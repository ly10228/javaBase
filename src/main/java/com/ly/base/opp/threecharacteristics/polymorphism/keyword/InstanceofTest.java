package com.ly.base.opp.threecharacteristics.polymorphism.keyword;

import com.ly.base.opp.threecharacteristics.polymorphism.Man;
import com.ly.base.opp.threecharacteristics.polymorphism.Person;
import com.ly.base.opp.threecharacteristics.polymorphism.Woman;
import org.junit.Test;

/**
 * @author luoyong
 * @Description: instanceof关键字的使用
 * a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
 * <p>
 * <p>
 * 使用情境：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先
 * 进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。
 * <p>
 * 如果 a instanceof A返回true,则 a instanceof B也返回true.
 * 其中，类B是类A的父类。
 * @create 2019-11-04 22:46
 * @last modify by [LuoYong 2019-11-04 22:46]
 **/
public class InstanceofTest {
    @Test
    public void test() {
        //对象的多态性：父类的引用指向子类的对象
        Person p2 = new Man();
//		Person p3 = new Woman();
        //多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法 ---虚拟方法调用
        p2.eat();
        p2.walk();


//		p2.earnMoney();

        //1001
        System.out.println(p2.getId());

        System.out.println("****************************");
        //不能调用子类所特有的方法、属性：编译时，p2是Person类型。
        p2.setName("Tom");
//		p2.earnMoney();
//		p2.isSmoking = true;
        //有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致
        //编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。

        //如何才能调用子类特有的属性和方法？
        //向下转型：使用强制类型转换符。
        Man m1 = (Man) p2;
        m1.earnMoney();
        m1.setSmoking(true);

        //使用强转时，可能出现ClassCastException的异常。
//		Woman w1 = (Woman)p2;
//		w1.goShopping();
        if (p2 instanceof Woman) {
            Woman w1 = (Woman) p2;
            w1.goShopping();
            System.out.println("******Woman******");
        }

        if (p2 instanceof Man) {
            Man m2 = (Man) p2;
            m2.earnMoney();
            System.out.println("******Man******");
        }

        if (p2 instanceof Person) {
            System.out.println("******Person******");
        }
        if (p2 instanceof Object) {
            System.out.println("******Object******");
        }
    }
}
