# FrameWorkJAVA.Spring

## 1.简介

### 方法

#### 1.基本概念

- 核心其一是AOP，面向切面编程，修改功能不是修改源代码实现
- 核心其二是IOC，是反转控制，将获取到的对象的生命周期交给Spring管理，比如之前new的对象，现在变为直接从Spring获取
- Spring是一站式框架，在JavaEE中提供三层结构中，都有解决技术。web层为SpringMVC、servlet层为Spring的IOC、dao层为Spring的jdbcTemplate
- POJO，即 Plain Old Java Objects，简单老式 Java 对象。它可以包含业务逻辑或持久化逻辑，但不担当任何特殊角色且不继承或不实现任何其它Java框架的类或接口。
- IOC和DI区别
  1. IOC是反转控制，将对象创建交给Spring处理
  2. DI是依赖注入，向类里面设置属性值
  3. 两者关系：DI是无法单独存在的，需要在IOC基础上完成操作

- **Spring整合Web项目原理——重点**

  - 实现思想

    核心配置文件applicationContext.xml，在服务器启动时完成

  - 实现原理

    使用ServletContext对象、监听器

  - 具体步骤
    1. 服务器启动时，会为每个项目创建ServletContext对象
    2. 监听器监测到ServletContext对象创建
    3. 加载Spring配置文件，把配置文件配置对象创建
    4. 创建出来的对象放入ServletContext域中（setAttribute方法）
    5. 获取对象时，从ServletContext域中获取（getAttribute方法）

  

## 2.IOC

### 方法

#### 1.底层原理

![](/Users/toyz/Package/FrameWorkJAVA/Note/ioc底层原理.png)

- dom4j是一个Java的XML API,用来读写xml文件
- UserServlet为了得到UserService对象
  1. 使用xml配置文件：配置对象类的id和路径
  2. 创建工厂类来解析配置文件以及反射：获取对象类的路径值，使用反射创建类对象
  3. 通过工厂类的获取方法来获取UserService对象

- 需掌握IOC原理，以及以下代码：

  ```java
  Class clazz = Class.forName(classValue);
  UserService service = clazz.newInstance();
  ```

#### 2.实现步骤

- 导入jar包，包括核心四个包：context、core、bean、expression，以及输出日志的log包

- 新建对象类User，并编写基本方法

- 创建xml配置文件

  1. 引入约束

     ```xml
     <beans xmlns="http://www.springframework.org/schema/beans"
     
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     
            xsi:schemaLocation="http://www.springframework.org/schema/beans  http://www.springframework.org/schema/beans/spring-beans.xsd">
     ```

     

  2. 建立bean类型的名称和路径

  3. 建立测试类，包括加载xml配置文件，并创建对象；得到创建对象并执行对象方法

     （**getBean()方法相当于获取了工厂类返回的对象**）

     ```java
         public void testUser(){
     //        1.加载spring配置文件，创建对象
             ApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml");
             User user = (User)context.getBean("user");
             user.add();
         }
     ```

     <!--联想-->

     ```
     1.XML配置文件，类似奶茶店，你可以调节奶茶的甜度、容量等参数
     2.对象类，类似一杯奶茶，你可以新增属性比如甜度、容量和方法
     3.执行类，先访问奶茶店（加载配置文件），然后直接从奶茶店买一杯奶茶（getBean()方法）
     ```

     

## 3.Bean管理

### 方法

#### 1.实例化方式

- 使用无参构造方法创建，包括Bean1.<!--有参数的构造方法，会导致运行出错-->

  ```java
  package bean;
  // 使用无参构造方法的类
  public class Bean1 {
  //    以下为有参数的构造方法，会导致运行出错，因此需要删除
      //    public String name;
  //
  //    public Bean1(String name) {
  //        this.name = name;
  //    }
  }
  ```

- 使用静态工厂创建，包括Bean2.java,Bean2Factory.java

  ```java
  package bean;
  public class Bean2Factory {
      public static Bean2 getBean2(){
          return new Bean2();
      }
  }
  ```

- 使用实例工厂创建，包括Bean3.java,Bean3Factory.java

  ```java
  package bean;
  public class Bean3Factory {
      public Bean3 getBean3(){
          return new Bean3();
      }
  }
  ```

- 配置文件：applicationContext.xml

  ```xml
  <!--  1.Bean实例化的三种方式  -->
      <!--  1.1 使用类的无参构造创建  -->
      <bean id="bean1" class="bean.Bean1" />
  
      <!--  1.2 使用静态工厂创建(bean.Bean2,bean.Bean2Factory)  -->
      <bean id="bean2" class="bean.Bean2Factory" factory-method="getBean2" />
  
      <!--  1.3 使用实例工厂创建(bean.Bean3,bean.Bean3Factory)-->
          <!--  1.3.1 创建工厂对象-->
          <bean id="bean3Factory" class="bean.Bean3Factory" />
          <!--  1.3.2 使用工厂对象创建-->
          <bean id="bean3" factory-bean="bean3Factory" factory-method="getBean3" />
  ```

#### 2.常用属性

- 实现1
- id：根据id得到配置对象，不能包含特殊字符
- name：功能与id基本一致，可以包含特殊字符，但已经不用
- class：创建对象所在的全路径
- scope：共有五种属性值，singleton、prototype、request、session、globalsession
  1. singleton：默认值，单例，获取到的对象地址相同
  2. prototype：多例，获取到的对象不同
  3. request：创建对象并放到request域里面
  4. session：创建对象并放到session域里面
  5. globalsession：创建对象并放到globalsession域里面 <!--单点登录，使用的原理是globalsession-->

#### 3.属性注入

- Java常用属性注入方式

  1. set方法注入

     ```java
     Public class User(){
     	public String name;
       public void set(String name){
         this.name = name;
       }
       
       User user = new User();
       user.set("abc");
     }
     ```

  2. 有参构造方法注入

     ```java
     public class User(){
     	public String name;
       public User(String name){
        this.name = name; 
       }
     }
     
     	User user = new User("abc");
     ```

  3. 使用接口注入

     - 接口

     ```java
     public interface Dao(){
     	public void delete(String name);
     }
     ```

     - 注入

     ```java
     public class UserDao implements Dao{
     	private String name;
       public void delete(String name){
         this.name = name;
       }
     }
     ```

- Spring框架中支持set方法、有参构造方法注入属性、p空间注入

  1. set方法注入（主要方法）

     <!--类文件.java-->

     ```java
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
     ```
      <!--配置文件.xml-->
     ```xml
     		<!--2.2 set方法注入-->
         <bean id="beanSet2" class="bean.Bean3">
             <property name="beanName" value="Tom" />
         </bean>
     ```

  2. 有参构造方法注入

     <!--类文件.java-->
     
     ```java
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
     ```
     
      <!--配置文件.xml-->
     
     ```xml
         <!--2.1 有参的构造方法注入-->
        <bean id="beanSet" class="bean.Bean2">
             <constructor-arg name="beanName" value="Toyz" />
       </bean>
     ```
     
  3. p空间注入——少见
  
     <!--类文件.java-->
  
     ```java
     public class pBean(){
       private String pName;
       public void setPName(String pName){
         this.pName = pName;
       }
     }
     ```
  
     <!--配置文件.xml-->
  
     ```xml
     <beans xmlns="http://www.springframework.org/schema/beans"
     
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:p="http://www.springframework.org/schema/p"
            xsi:schemaLocation="http://www.springframework.org/schema/beans  http://www.springframework.org/schema/beans/spring-beans.xsd">
     
         <bean id="pBean" class="bean.pBean" p:pName="Toyz" />
     </beans>
     ```

#### 4.对象类型属性注入——重点

- 步骤

  1. 创建两个类，副类无参，主类将副类作为属性并添加set方法

     <!--主类.java-->

     ```java
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
     ```

     <!--副类.java-->

     ```java
     package bean;
     // 作为属性被注入到UserService类,不需要有属性，因此使用无参构造法创建实例
     public class UserDao {
         public void add(){
             System.out.println("UserDao...");
         }
     }
     ```

  2. 配置文件中，先实例化两个类的对象，然后将对象作为属性注入

     <!--配置文件.xml-->

     ```xml
      <!--3.注入对象类型属性-->
             <!--3.1 实例化两个对象-->
             <bean id="userDao" class="bean.UserDao" />
             <bean id="userService" class="bean.UserService">
                 <!--3.2 将对象作为属性注入-->
                 <property name="userDao" ref="userDao" />
             </bean>
     ```

- 注意
  1. **配置文件中，property标签中的name属性和ref属性，分别代表UserService类中的属性名称、dao配置bean标签中的id值（指实例化对象）**

#### 5.复杂类型属性注入

- 步骤

  1. 新建类，包含复杂的类型作为属性，（字符串数组、list、map、propertise），并新建测试方法

     <!--类.java-->

     ```java
     package bean;
     import java.util.List;
     import java.util.Map;
     import java.util.Properties;
     //复杂类型的属性注入
     public class MultipleBean {
         private String[] strings;
         private List<String> list;
         private Map<String,String> map;
         private Properties properties;
         public void setStrings(String[] strings) {
             this.strings = strings;
         }
         public void setList(List<String> list) {
             this.list = list;
         }
         public void setMap(Map<String, String> map) {
             this.map = map;
         }
         public void setProperties(Properties properties) {
             this.properties = properties;
         }
         public void test(){
             System.out.println("strings:"+strings);
             System.out.println("list:"+list);
             System.out.println("map:"+map);
             System.out.println("properties:"+properties);
         }
     }
     ```

  2. 配置复杂类型属性的值

     <!--配置文件.xml-->

     ```xml
     <!--4. 复杂类型的属性注入-->
             <!--4.1 实例化对象-->
             <bean id="multipleBean" class="bean.MultipleBean">
                 <!--4.1.1 数组类型属性注入-->
                 <property name="strings" >
                     <list>
                         <value>strings1</value>
                         <value>strings2</value>
                         <value>strings3</value>
                     </list>
                 </property>
                 <!--4.1.2 List类型属性注入-->
                 <property name="list">
                     <list>
                         <value>list1</value>
                         <value>list2</value>
                         <value>list3</value>
                     </list>
                 </property>
                 <!--4.1.3 Map类型属性注入-->
                 <property name="map">
                     <map>
                         <entry key="m1" value="map1"></entry>
                         <entry key="m2" value="map2"></entry>
                         <entry key="m3" value="map3"></entry>
                     </map>
                 </property>
                 <!--4.1.4 Properties类型属性注入-->
                 <property name="properties">
                     <props>
                         <prop key="p1">pro1</prop>
                         <prop key="p2">pro2</prop>
                         <prop key="p3">pro3</prop>
                     </props>
                 </property>
             </bean>
     ```

#### 6.注解创建对象、注入属性

- 准备工作

  1. 导入jar包，并在配置文件中添加约束

  2. 添加声明，开启注解扫描，有两种方式，区别如下

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
            xsi:schemaLocation="
             http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
             http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
     
         <!--用于扫描有注解的声明-->
         <context:component-scan base-package="bean" />
     
         <!--仅仅扫描属性上的注解-->
         <!--<context:annotation-config></context:annotation-config>-->
     </beans>
     ```

- 创建对象

  1. 创建类文件

  2. 编写类中属性和方法

  3. 在类中注解，Component/Service/Controller/Repository四种方式功能一样

     ```java
     package bean;
     import org.springframework.context.annotation.Scope;
     import org.springframework.stereotype.Service;
     // 注解，Component/Service/Controller/Repository四种方式功能一样
     @Service(value = "user")
     @Scope(value = "prototype")
     public class User {
         public void add(){
             System.out.println("add...");
         }
     }
     ```

- 注入属性

  1. 创建主类和副类

  2. 主类和副类分别使用注解创建对象

  3. 主类添加副类为属性

  4. 在副类属性上添加注解，包含两种@Resource/@Autowired

  5. **@Resource和@Autowired区别是：@Resource有name属性，匹配这个值对应的类，相当于bean的id属性；@Autowired无其他属性，直接通过副类的名称匹配**

     ```java
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
     
     ```

- 创建对象和注入属性混合方法，实现2

### 实现

- 实现1

  ```java
  package test;
  
  import bean.Bean1;
  import org.springframework.context.ApplicationContext;
  import org.springframework.context.support.ClassPathXmlApplicationContext;
  
  public class TestCommonProperty {
      public static void main(String[] args) {
          ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  
  //        1.常用属性
  //        1.1 scope属性为singleton
          Bean1 bean1 = (Bean1) context.getBean("bean1");
          Bean1 bean2 = (Bean1) context.getBean("bean1");
          System.out.println("1.1 scope属性为singleton");
          System.out.println("bean1地址为："+bean1);
          System.out.println("bean2地址为："+bean2);
  //        1.2 scope属性为prototype
          Bean1 bean3 = (Bean1) context.getBean("bean2");
          Bean1 bean4 = (Bean1) context.getBean("bean2");
          System.out.println("1.2 scope属性为prototype");
          System.out.println("bean3地址为："+bean3);
          System.out.println("bean4地址为："+bean4);
      }
  }
  ```

  ```xml
  <!--引入约束-->
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.springframework.org/schema/beans  http://www.springframework.org/schema/beans/spring-beans.xsd">
      <!--    1. 常用的属性-->
      <!--    1.1 scope属性singleton为默认属性，单例 -->
      <bean id="bean1" class="bean.Bean1" scope="singleton" />
      <!--    1.2 scope属性prototype为多例 -->
      <bean id="bean2" class="bean.Bean1" scope="prototype" />
  </beans>
  ```

- 实现2

  <!--三个类.java，一主类，两副类-->

  ```java
  package bean;
  import org.springframework.beans.factory.annotation.Autowired;
  import javax.annotation.Resource;
  // 配置文件和注解混合使用
  // 配置文件生成对象
  // 注解注入属性
  public class BookService {
  
      @Autowired
      private BookDao bookDao;
  
      @Resource(name = "orderDao123")
      private OrderDao orderDao;
  
      public void add(){
          System.out.println("BookService...");
          bookDao.add();
          orderDao.add();
      }
  }
  ```

  ```java
  package bean;
  import org.springframework.stereotype.Service;
  public class BookDao {
      public void add(){
          System.out.println("BookDao...");
      }
  }
  ```

  ```java
  package bean;
  import org.springframework.stereotype.Service;
  public class OrderDao {
      public void add(){
          System.out.println("OrderDao...");
      }
  }
  ```

  <!--配置文件.xml-->

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="
          http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
  
      <!--用于扫描有注解的声明-->
      <context:component-scan base-package="bean" />
  
      <!--仅仅扫描属性上的注解-->
      <!--<context:annotation-config></context:annotation-config>-->
  
      <!--生成类对象-->
      <bean id="bookDao" class="bean.BookDao"/>
      <bean id="orderDao123" class="bean.OrderDao"/>
      <bean id="bookService" class="bean.BookService"/>
  </beans>
  ```

  <!--测试类.java-->

  ```java
  package test;
  import bean.BookService;
  import org.junit.Test;
  import org.springframework.context.ApplicationContext;
  import org.springframework.context.support.ClassPathXmlApplicationContext;
  public class TestMultiCreate {
      @Test
      public void test() {
          ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
          BookService bookService = (BookService) context.getBean("bookService");
          bookService.add();
      }
  }
  ```

  

### 索引

1.实例化的三种方式

- /Users/toyz/Package/FrameWorkJAVA/Spring/Spring.Bean/Spring.Bean.Instantiation

3.属性注入，4.对象类型属性注入，5.复杂类型属性注入

- /Users/toyz/Package/FrameWorkJAVA/Spring/Spring.Bean/Spring.Bean.Property











