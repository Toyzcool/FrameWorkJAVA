package bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

// 注解，Component/Service/Controller/Repository四种方式功能一样
@Service(value = "user")
@Scope(value = "prototype")
public class User {
    public void add(){
        System.out.println("add...");
    }
}
