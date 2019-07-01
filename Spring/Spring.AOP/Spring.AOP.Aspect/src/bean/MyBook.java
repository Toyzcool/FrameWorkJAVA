package bean;

// 当前类为增强类

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyBook {
    @Before(value = "execution(* bean.Book.add(..))")
    public void before(){
        System.out.println("前置增强");
    }
    @After(value = "execution(* bean.Book.add(..))")
    public void after(){
        System.out.println("最终增强");
    }
    @AfterReturning(value = "execution(* bean.Book.add(..))")
    public void afterReturning(){
        System.out.println("后置增强");
    }
    @Around(value = "execution(* bean.Book.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕增强前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕增强后");
    }
}
