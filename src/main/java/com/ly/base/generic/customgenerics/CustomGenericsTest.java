package com.ly.base.generic.customgenerics;

import com.ly.base.generic.customgenerics.dto.Order;
import com.ly.base.generic.customgenerics.dto.Person;
import com.ly.base.generic.customgenerics.dto.SubOrder;
import com.ly.base.generic.customgenerics.dto.SubOrder1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2019-12-14 10:13
 *  * @last modify by [luoyong 2019-12-14 10:13]
 * @Description: CustomGenericsTest 自定义泛型测试
 **/
public class CustomGenericsTest {
    /**
     * @return void
     * @Description: 泛型类的测试
     * @author luoyong
     * @create 10:32 2019-12-14
     * @last modify by [LuoYong 10:32 2019-12-14 ]
     */
    public void test1() {
        //如果定义了泛型类 类在实例化的时候没有指明类的泛型，默认泛型类型是Object
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT("20191213");
        order.setOrderT("20191214");

        //类实例化对象的时候指明了泛型
        Order<String> order1 = new Order<>();
        order1.setOrderT("2019");
        //只能写入String类型的值 其他类型在编译器会报错
//        order1.setOrderT(1);
    }

    @Test
    public void test2() {
        //子类在继承父类的时候指明了泛型类型，则在子类对象实例化的时候，不需要再指明泛型类型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(112);

        SubOrder1<String> subOrder1 = new SubOrder1();
        subOrder1.setOrderT("test");
    }


    @Test
    public void test3() {
        ArrayList<String> stringArrayList = null;
        ArrayList<Integer> intArrayList = null;
//        System.out.println(stringArrayList == intArrayList);

        Person p1 = null;
        Person p2 = null;
        p1 = p2;
    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }

}
