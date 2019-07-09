package com.Handler;

import com.Exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception")
public class ErrorHandler {
    @RequestMapping("testException")
    public String testException() throws SysException{
        System.out.println("testException.....");
        // 模拟异常
        try {
            int a = 10/0;
        } catch (Exception e){
            e.printStackTrace();
            throw new SysException("查询了所有用户");
        }
        return "success";
    }
}
