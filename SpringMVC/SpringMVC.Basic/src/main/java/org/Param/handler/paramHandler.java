package org.Param.handler;

import domin.Account;
import domin.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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

    /*
    3.自定义类型转换
    */
    @RequestMapping("saveUser")
    public String saveDate(User user){
        System.out.printf("Date转换成功");
        System.out.println(user);
        return "success";
    }

    /*
    4.获取原生的Servlet API
    */
    @RequestMapping("getServletAPI")
    public String getServletAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.printf("getServletAPI");
        System.out.println(request);
        System.out.println(response);
        HttpSession httpSession = request.getSession();
        System.out.println(httpSession);
        return "success";
    }
}


