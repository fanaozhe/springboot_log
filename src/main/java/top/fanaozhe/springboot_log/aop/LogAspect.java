package top.fanaozhe.springboot_log.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author faz
 * @create 2020-12-21-15:05
 */
@Component
@Aspect
@Order(200)
public class LogAspect {
    @Pointcut("execution(* top.fanaozhe.springboot_log.service.*.*(..))")
    public void pc(){}

    /**
     * 前置通知
     * @param jp
     */
    @Before(value = "pc()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name +"方法开始执行(*****基于类******)......");
    }

    /**
     *后置通知
     * @param jp
     */
    @After(value = "pc()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name +"方法执行结束......");
    }

    /**
     * 返回通知
     * @param jp
     * @param result
     */
    @AfterReturning(value = "pc()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回值为："+result);
    }

    /**
     * 异常通知
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "pc()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e){
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛出异常，异常是"+e.getMessage());
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        return pjp.proceed();
    }

}
