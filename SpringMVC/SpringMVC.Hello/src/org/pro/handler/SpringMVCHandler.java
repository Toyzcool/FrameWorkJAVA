package org.pro.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCHandler {
    @RequestMapping("welcome")
    public String welcome(){
        return "success";
    }
}