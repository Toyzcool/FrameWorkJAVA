package com.Handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class InterceptorHandler {
    @RequestMapping("testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor execute");
        return "success";
    }
}
