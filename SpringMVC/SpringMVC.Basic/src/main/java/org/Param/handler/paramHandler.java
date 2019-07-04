package org.Param.handler;

import domin.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("param")
public class paramHandler {

    /*
    1.请求参数绑定入门
     */
    @RequestMapping("testParam")
    public String testParam(String username,String password){
        System.out.printf("Username:"+username+"  and password:"+password);
        return "success";
    }

    /*
    2.请求参数绑定封装到JavaBean中
    */
    @RequestMapping("savaAccount")
    public String saveAccount(Account account){
        System.out.printf("Account封装成功");
        System.out.println(account);
        return "success";
    }
}


