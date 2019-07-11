package com.Interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor {
    /*
  预处理方法，在handler之前
   */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor2_Pre_Execute");
        return true;
    }
    /*
    后处理方法,在success之前，在handler之后
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable
        ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor2_Post_Execute");
    }
    /*
    在success之后
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("MyInterceptor2_last_Execute");
    }
}
