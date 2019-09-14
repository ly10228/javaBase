package com.ly.senior.designpatterns.structured.adapter.objectadapter;


import com.ly.senior.designpatterns.structured.adapter.classadapter.Phone;
import com.ly.senior.designpatterns.structured.adapter.classadapter.Voltage220V;
import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client 对象配器模式
 * 对象适配器和类适配器其实算是同一种思想，只不过是实现方式不同。根据合成复用原则，使用组合代替继承，解决了类适配器必须继承src的局限性问题，也不再要求dst必须是接口
 * 使用成本更低，更灵活
 * @create 2019-09-14 9:47
 * @last modify by [LuoYong 2019-09-14 9:47]
 **/
public class Client {

    @Test
    public void test() {
        System.out.println("==== 对象配器模式 ===");
        //被适配的对象
        Voltage220V voltage220V = new Voltage220V();
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(voltage220V));
    }
}
