package org.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingHandler {

    //    Value、path属性效果一样，同时可以省略属性名称
//    设计二级value = "/user/testValue"，用于划分模块——关联RequestMappingHandler2.java
    @RequestMapping("user/testValue")
    public String testValue(){
        System.out.println("testValue...user");
        return "success";
    }

    //   method属性，指定响应的请求类型
//    因为默认请求类型为get，因此请求失败
    @RequestMapping(value = "testMethod",method = {RequestMethod.POST})
    public String testMethod(){
        System.out.println("testMethod...");
        return "success";
    }

    //    params属性，指定必须要传输的参数(username),而且值为Toyz
    @RequestMapping(value = "testParams",params = {"username=Toyz"})
    public String testParams(){
        System.out.println("testParams...username");
        return "success";
    }

    //    header属性
    @RequestMapping(value = "testHeader",headers = {"Accept"})
    public String testHeader(){
        System.out.println("testHeader...Accept");
        return "success";
    }

}
