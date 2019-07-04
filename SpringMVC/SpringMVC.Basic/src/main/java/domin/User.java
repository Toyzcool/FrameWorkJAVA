package domin;

import java.io.Serializable;
/*
当前类作为对象属性注入Account中
 */
public class User implements Serializable {
    public String uname;
    public Integer age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
