package test;

import bean.MultipleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultipleProperty {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    复杂类型的属性注入
        MultipleBean multipleBean = (MultipleBean) context.getBean("multipleBean");
        multipleBean.test();
    }

}
