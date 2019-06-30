package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {

//    属性注解方式一，不需要set方法
//    @Autowired
//    private UserDao userDao;

//    属性注解方式二，不需要set方法
    @Resource(name = "userDao123")
    private UserDao userDao;


    public void add(){
        System.out.println("UserService...");
        userDao.add();
    }
}
