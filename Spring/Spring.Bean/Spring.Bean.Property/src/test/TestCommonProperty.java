package test;

import bean.Bean1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCommonProperty {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        1.常用属性
//        1.1 scope属性为singleton
        Bean1 beanSingleton1 = (Bean1) context.getBean("beanSingleton");
        Bean1 beanSingleton2 = (Bean1) context.getBean("beanSingleton");
        System.out.println("1.1 scope属性为singleton");
        System.out.println("beanSingleton1地址为："+beanSingleton1);
        System.out.println("beanSingleton2地址为："+beanSingleton2);
//        1.2 scope属性为prototype
        Bean1 beanPrototype1 = (Bean1) context.getBean("beanPrototype");
        Bean1 beanPrototype2 = (Bean1) context.getBean("beanPrototype");
        System.out.println("1.2 scope属性为prototype");
        System.out.println("beanPrototype1地址为："+beanPrototype1);
        System.out.println("beanPrototype2地址为："+beanPrototype2);
    }
}
