package test;

import bean.Bean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetProperty {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        1.有参构造方法注入
        Bean2 bean2 = (Bean2) context.getBean("beanSet");
        bean2.setSucceed();
    }
}
