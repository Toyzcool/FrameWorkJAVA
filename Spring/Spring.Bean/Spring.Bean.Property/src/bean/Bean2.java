package bean;
// 有参的构造方法实现注入
public class Bean2 {
    private String name;

    public Bean2(String name) {
        this.name = name;
    }
    public void setSucceed(){
        System.out.println("通过有参构造方法注入成功,name:"+name);
    }
}
