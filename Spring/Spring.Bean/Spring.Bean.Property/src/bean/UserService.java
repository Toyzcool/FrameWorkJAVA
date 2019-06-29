package bean;
// 注入对象类型属性
public class UserService {
//    UserDao作为属性
    public UserDao userDao;
//    属性的set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("UserService...");
        userDao.add();
    }
}
