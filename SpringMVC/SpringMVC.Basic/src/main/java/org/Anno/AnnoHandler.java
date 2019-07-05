package org.Anno;

import domin.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

@Controller
@RequestMapping("/anno")
@SessionAttributes({"sessionName"}) //该注解只用于类，把数据存储在Session域里面
public class AnnoHandler {
    /*
    1.RequestParam 获取请求参数
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println(username);
        return "success";
    }

    /*
    2.RequestBody 获取请求体，获取请求体内容（常用于JSON）
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    /*
    3.PathVariable 绑定占位符，获取占位符
     */
    @RequestMapping("/testPathVariable/{pid}")
    public String testPathVariable(@PathVariable(name = "pid") String id){
        System.out.println(id);
        return "success";
    }

    /*
   4.RequestHeader 获取请求头部
    */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String requestHeader){
        System.out.println(requestHeader);
        return "success";
    }

    /*
   5.CookieValue 指定 cookie 名称的值传入控制器方法参数
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

    /*
    6.ModelAttribute
    出现在方法上，表示当前方法会在控制器的方法执行之前，先执行。
    修饰没有返回值的方法，也可 以修饰有具体返回值的方法。
    出现在参数上，获取指定的数据给参数赋值。
    */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println(user);
        return "success";
    }
//    当前方法会返回一个user对象，被上面的方法获取，能够补充缺省的参数date
    @ModelAttribute
    public User showUser(String name){
        User user = new User();
        user.setUname("toyz");
        user.setAge(50);
        user.setDate(new Date());
        return user;
    }

//    ModelAttribute 注解在方法上，该方法会优先于控制器中的其他方法之前执行
    @ModelAttribute
    public void showModelAttribute(){
    System.out.println("ModelAttribute先执行");
}

    /*
      7.SessionAttribute 向Session中传值、获取值、删除值
    */
    //  把数据存入 Request域里面
    @RequestMapping("/setSessionAttribute")
    public String setSessionAttribute(Model model){
        model.addAttribute("sessionName","session胜利！！！！");
        System.out.println("setSessionAttribute...");
        return "success";
    }
    //  把数据从 SessionAttribute 取出
    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(ModelMap model){
        System.out.println("getSessionAttribute...");
        System.out.println("getSessionAttribute取出设置的sessionName值："+model.get("sessionName"));
        return "success";
    }
    //  把数据从 SessionAttribute 删除
    @RequestMapping("/delSessionAttribute")
    public String delSessionAttribute(SessionStatus status){
        status.setComplete();
        return "success";
    }
}
