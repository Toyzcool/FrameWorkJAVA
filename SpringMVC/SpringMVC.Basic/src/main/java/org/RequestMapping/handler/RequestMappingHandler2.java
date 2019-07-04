package org.RequestMapping.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//    类中添加value = "/order"，用于划分模块
@RequestMapping("order")
public class RequestMappingHandler2 {
    //    测试value值
    @RequestMapping("testValue")
    public String testValue(){
        System.out.println("testValue...oder");
        return "success";
    }
}
