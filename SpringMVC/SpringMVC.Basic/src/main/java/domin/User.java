package domin;

import java.io.Serializable;
import java.util.Date;

/*
当前类作为对象属性注入Account中
 */
public class User implements Serializable {
    private String uname;
    private Integer age;

    private Date date;

    public String getUname() { return uname; }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
