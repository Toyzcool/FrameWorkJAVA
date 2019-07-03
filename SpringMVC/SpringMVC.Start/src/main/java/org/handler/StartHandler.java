package org.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartHandler {

    @RequestMapping("/hello")
    public String start(){
        System.out.printf("Hello");
        return "success";
    }
}
