package domin;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/*
当前类作为对象属性注入Account中
 */

//使用Lombok注解@Data能够自动生成set、get、toString方法
@Data
public class User implements Serializable {
    private String uname;
    private Integer age;
    private Date date;
}
