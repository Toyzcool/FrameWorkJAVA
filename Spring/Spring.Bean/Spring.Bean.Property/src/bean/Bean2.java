package bean;
// 有参的构造方法实现注入
public class Bean2 {
    private String beanName;

    public Bean2(String beanName) {
        this.beanName = beanName;
    }

    public void setSucceed(){
        System.out.println("通过有参构造方法注入成功,beanName:"+beanName);
    }
}
