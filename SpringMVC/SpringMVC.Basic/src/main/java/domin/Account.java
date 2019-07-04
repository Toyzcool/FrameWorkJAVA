package domin;

import java.io.Serializable;

/*
请求参数绑定把数据装到当前类中,将对象属性User注入
 */
public class Account implements Serializable {
    public String username;
    public String password;
    public int money;

    public User user;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney() {
        return money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user.uname=" + user.uname +
                ", user.age=" + user.age +
                '}';
    }
}
