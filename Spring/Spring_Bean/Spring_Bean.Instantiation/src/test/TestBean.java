package test;

import bean.Bean1;
import bean.Bean2;
import bean.Bean3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        获取bean对象
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        Bean3 bean3 = (Bean3) context.getBean("bean3");
//        输出bean对象地址
        System.out.println("bean1地址为："+bean1);
        System.out.println("bean2地址为："+bean2);
        System.out.println("bean3地址为："+bean3);
    }
}
