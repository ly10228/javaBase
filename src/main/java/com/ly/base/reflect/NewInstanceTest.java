package com.ly.base.reflect;

import com.ly.base.reflect.dto.Person;
import org.junit.Test;

import java.util.Random;

/**
 * @author luoyong
 *  * @create 2019-12-04 20:00
 *  * @last modify by [luoyong 2019-12-04 20:00]
 * @Description: NewInstanceTest
 **/
public class NewInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        /**
         * newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。
         *
         *要想此方法正常的创建运行时类的对象，要求：
         *   1.运行时类必须提供空参的构造器
         *   2.空参的构造器的访问权限得够。通常，设置为public。
         *
         *
         *在javabean中要求提供一个public的空参构造器。原因：
         *   1.便于通过反射，创建运行时类的对象
         *   2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        System.out.println(person);
    }

    /**
     * @return void
     * @Description: 测试反射的动态性
     * @author luoyong
     * @create 20:06 2019-12-04
     * @last modify by [luoyong 20:06 2019-12-04 ]
     */
    @Test
    public void testDynamicsOfReflect() {
        for (int i = 0; i <= 100; i++) {
            String classPath = "";
            //0,1,2
            int num = new Random().nextInt(3);
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.ly.base.reflect.dto.Person";
                    break;
            }
            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    private Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        Object o = clazz.newInstance();
        return o;
    }

}
