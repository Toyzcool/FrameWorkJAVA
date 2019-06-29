package test;

import bean.Bean2;
import bean.Bean3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetProperty {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        1.有参构造方法注入
        Bean2 beanSet = (Bean2) context.getBean("beanSet");
        beanSet.setSucceed();
//        2.set方法注入
        Bean3 beanSet2 = (Bean3) context.getBean("beanSet2");
        beanSet2.setSucceed();
    }
}
