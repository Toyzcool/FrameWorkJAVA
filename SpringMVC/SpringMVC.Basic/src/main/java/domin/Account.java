package domin;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
请求参数绑定把数据装到当前类中,将对象属性User注入
 */

//使用Lombok注解@Data能够自动生成set、get、toString方法
@Data
public class Account implements Serializable {
    public String username;
    public String password;
    public int money;
    private List<User> list;
    private Map<String, User> map;
}
