import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    public void testUser(){
//        1.加载spring配置文件，创建对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)context.getBean("user");
        user.add();
    }

    public static void main(String[] args) {
        TestIOC ti = new TestIOC();
        ti.testUser();
    }
}
