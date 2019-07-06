package com.Handler;

import com.Domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserHandler {
    /*
    1.响应返回是String类型
     */
    @RequestMapping("testString")
    public String showUser(Model model){
        User user = new User();
        user.setUsername("toyz");
        user.setPassword("123");
        user.setAge(23);
        model.addAttribute("user", user);
        return "success";
    }

    /*
    2.响应返回是void类型
     */
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//        1. 编写转发请求的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

//        2. 重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

//        3. 直接进行响应
    //        3.1 中文编码
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
    //        3.2 响应内容
            response.getWriter().print("<h2>直接响应成功</h2>");
    }

    /*
    3.响应返回是ModelAndView类型
    */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){

        User user = new User();
        user.setUsername("Muser");
        user.setPassword("321");
        user.setAge(100);
//        create ModelAndView object
        ModelAndView mv = new ModelAndView();
//        add object
        mv.addObject("user", user);
//        add transition
        mv.setViewName("success");
        return mv;
    }

    /*
    4.使用关键字进行转发和重定向
     */
    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect() {
//                1. 编写转发请求的程序
//                return "forward:/WEB-INF/pages/success.jsp";

        //        2. 重定向
                return "redirect:/index.jsp";
    }

    /*
    5.Ajax进行异步请求
     */
    @RequestMapping("testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax...execution");
        System.out.println(user);
        user.setUsername("newAjax");
        user.setAge(999);
        return user;
    }
}
