package top.fanaozhe.springboot_log.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author faz
 * @create 2020-12-23-8:47
 */
@Component
@Aspect
@Order(100)
public class LogAspectMethod {

    @Pointcut("execution(* top.fanaozhe.springboot_log.service.UserService.getUserById(Integer))")
    public void pc(){}

    @Before(value = "pc()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name +"方法开始执行(****基于方法*****)......");
    }
}
