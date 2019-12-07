package com.ly.base.reflect.exer;

import com.ly.base.reflect.exer.dto.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author luoyong
 *  * @create 2019-12-07 11:08
 *  * @last modify by [luoyong 2019-12-07 11:08]
 * @Description: 调用运行时类指定的结构：属性方法、方法、构造器
 **/
public class ReflectionTest {

    @Test
    public void testField() throws Exception {
        Class<Person> personClass = Person.class;
        //创建person实例对象
        Person person = personClass.newInstance();
        person.id = 10;
        System.out.println(person);

        Field id = personClass.getField("id");

        //给属性设置值
        id.set(person, 10228);

        System.out.println(person);

        //获取属性的值
        int idValue = (int) id.get(person);
        System.out.println("获取属性的值: " + idValue);

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "ly");
        System.out.println(name.get(person));

    }

    /**
     * @return void
     * @Description: 操作运行时类中指定的方法
     * @author luoyong
     * @create 16:43 2019-12-07
     * @last modify by [LuoYong 16:43 2019-12-07 ]
     */
    @Test
    public void testMethod() throws Exception {

        Class<Person> personClass = Person.class;

        //创建运行时类对象
        Person person = personClass.newInstance();

        //1 获取指定的某个方法
        Method show = personClass.getDeclaredMethod("show", String.class);

        //2:保证当前方法是可用的
        show.setAccessible(true);

        //3:调用invoke()方法 参数1：运行时类的对象 参数2：给方法形参赋值的实参
        //invoke()返回值即为对应类中调用方法的返回值
        String showMethodResult = (String) show.invoke(person, "中国");
        if (StringUtils.isNotBlank(showMethodResult)) {
            System.out.println(showMethodResult);
        }
        //调用私有静态的方法
        //private static void showDesc()
        Optional<Method> showDescOptional = Optional.of(personClass.getDeclaredMethod("showDesc"));
        if (showDescOptional.isPresent()) {
            Method showDesc = showDescOptional.get();
            showDesc.setAccessible(true);
            //Object returnVal = showDesc.invoke(null);
            Object returnVal = showDesc.invoke(Person.class);
            System.out.println(returnVal);
        }

    }

    /**
     * @return void
     * @Description: 调用运行时类指定的构造器
     * @author luoyong
     * @create 17:08 2019-12-07
     * @last modify by [LuoYong 17:08 2019-12-07 ]
     */
    @Test
    public void testConstructor() throws Exception {
        Class<Person> personClass = Person.class;

        //获取指定的构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);

        //2:保证访问权限
        declaredConstructor.setAccessible(true);

        //3:调用此构造器创建运行时类对象
        Person person = declaredConstructor.newInstance("ly");

        System.out.println(person);
    }


}
