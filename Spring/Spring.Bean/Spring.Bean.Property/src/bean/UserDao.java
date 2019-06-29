package bean;
// 作为属性被注入到UserService类,不需要有属性，因此使用无参构造法创建实例
public class UserDao {
    public void add(){
        System.out.println("UserDao...");
    }
}
