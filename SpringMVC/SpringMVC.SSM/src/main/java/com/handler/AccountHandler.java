package com.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountHandler {
    @RequestMapping("findAll")
    public String findAll(){
        System.out.println("表现层，展示所有用户");
        return "success";
    }
}
