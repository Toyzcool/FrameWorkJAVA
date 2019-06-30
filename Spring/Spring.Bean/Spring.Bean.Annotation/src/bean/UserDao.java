package bean;

import org.springframework.stereotype.Service;

@Service("userDao123")
public class UserDao {
    public void add(){
        System.out.println("UserDao...");
    }
}
