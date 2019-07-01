package bean;

import org.aspectj.lang.ProceedingJoinPoint;

public class Stone {
//    1 前置增强
    public void strengthBefore(){
        System.out.println("前置增强");
    }
//    2 后置增强
    public void strengthAfter(){
        System.out.println("后置增强");
    }
//    3 环绕增强
    public void strengthAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        3.1 方法之前
        System.out.println("环绕增强前");
        proceedingJoinPoint.proceed();
//        3.2 方法之后
        System.out.println("环绕增强后");
    }
}
