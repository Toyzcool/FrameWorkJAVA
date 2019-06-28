## FrameWorkJAVA

### A.Spring

### 1.简介

#### 方法

1.基本概念

- 核心其一是AOP，面向切面编程，修改功能不是修改源代码实现
- 核心其二是IOC，是反转控制，将获取到的对象的生命周期交给Spring管理，比如之前new的对象，现在变为直接从Spring获取
- Spring是一站式框架，在JavaEE中提供三层结构中，都有解决技术。web层为SpringMVC、servlet层为Spring的IOC、dao层为Spring的jdbcTemplate

- POJO，即 Plain Old Java Objects，简单老式 Java 对象。它可以包含业务逻辑或持久化逻辑，但不担当任何特殊角色且不继承或不实现任何其它Java框架的类或接口。

### 2.IOC

#### 方法

1.底层原理

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

2.基本实现步骤

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

     

### 3.Bean管理

#### 方法

1.bean实例化的三种方式

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

#### 索引

1.实例化的三种方式

- /Users/toyz/Package/FrameWorkJAVA/Spring/Spring_Bean/Spring_BeanInstantiation/Spring_Hello













