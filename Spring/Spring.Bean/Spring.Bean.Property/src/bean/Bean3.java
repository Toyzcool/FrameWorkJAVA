package bean;
// set方法注入属性值
public class Bean3 {
    private String beanName;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setSucceed() {
        System.out.println("set方法注入成功，beanName："+beanName);
    }
}
