package test;

import bean.Bean1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCommonProperty {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        1.常用属性
//        1.1 scope属性为singleton
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        Bean1 bean2 = (Bean1) context.getBean("bean1");
        System.out.println("1.1 scope属性为singleton");
        System.out.println("bean1地址为："+bean1);
        System.out.println("bean2地址为："+bean2);
//        1.2 scope属性为prototype
        Bean1 bean3 = (Bean1) context.getBean("bean2");
        Bean1 bean4 = (Bean1) context.getBean("bean2");
        System.out.println("1.2 scope属性为prototype");
        System.out.println("bean3地址为："+bean3);
        System.out.println("bean4地址为："+bean4);






    }
}
