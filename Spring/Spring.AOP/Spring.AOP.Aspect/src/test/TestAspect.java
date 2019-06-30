package test;

import bean.Weapon;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Weapon weapon = (Weapon) context.getBean("weapon");
        weapon.hit();
    }
}
