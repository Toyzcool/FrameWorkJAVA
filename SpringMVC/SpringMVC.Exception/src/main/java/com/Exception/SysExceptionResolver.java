package com.Exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {

    @Override public ModelAndView resolveException(HttpServletRequest httpServletRequest ,
        HttpServletResponse httpServletResponse , Object o , Exception ex) {
        // 获取到异常对象
        SysException e = null;
        if (ex instanceof SysException ){
            e = (SysException) ex;
        }else {
            e = new SysException("系统维护中");
        }
        // 创建ModelAndView对象，用于传值和跳转
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
