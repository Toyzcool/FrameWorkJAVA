package test;

import bean.Book;
import bean.Weapon;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnnotation {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_Annotation.xml");
        Book book = (Book) context.getBean("book");
        book.add();
    }
}
