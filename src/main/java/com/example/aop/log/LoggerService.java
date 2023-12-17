package com.example.aop.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerService{


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.example.aop.service.*)")
    public void paymentServicePointcut(){}

    @Pointcut("within(com.example.aop.controller.*)")
    public void paymentControllerPointcut(){}

    @Pointcut("paymentServicePointcut() || paymentControllerPointcut()")
    public void paymentServiceAndControllerPointcut(){}

    @Pointcut("execution(public void *()) && args()")
    public void acceptsNothingReturnVoid(){}

    @Pointcut("execution(public !void *()) && args()")
    public void acceptsNothingReturnAnyType(){}

    @Pointcut("execution(public !void *(..)) && args(*,..)")
    public void acceptsAnyArgsReturnAnyType(){}

    @Pointcut("execution(public void *(..)) && args(*,..)")
    public void acceptsAnyArgsReturnVoid(){}



    @Before("paymentServiceAndControllerPointcut() && acceptsNothingReturnVoid()")
    public void beforeCallMethod(JoinPoint jp) {
        logger.info(jp.getSignature().getDeclaringTypeName() + " call " + jp.getSignature().getName());
    }

    @Before("paymentServicePointcut() && acceptsAnyArgsReturnVoid()")
    public void beforeCallMethodWithArgs(JoinPoint jp) {
        Object[] args = jp.getArgs();
        logger.info(jp.getSignature().getDeclaringTypeName() + " call " + jp.getSignature().getName() + " with arguments: " + Arrays.toString(args));
    }

    @AfterReturning(value = "paymentServicePointcut() && acceptsNothingReturnAnyType()", returning = "returnValue")
    public void whenReturnSomething(JoinPoint jp,Object returnValue)  {
        logger.info(jp.getSignature().getDeclaringTypeName() + " call " + jp.getSignature().getName() + " then return: " + returnValue.toString());
    }

    @AfterReturning(value = "paymentServicePointcut() && acceptsAnyArgsReturnAnyType()", returning = "returnValue")
    public void whenReturnSometingWithArgs(JoinPoint jp,Object returnValue)  {
        Object[] args = jp.getArgs();
        logger.info(jp.getSignature().getDeclaringTypeName() + " call " + jp.getSignature().getName() + " with arguments: " + Arrays.toString(args) + " then return: " + returnValue.toString());
    }


    @AfterThrowing(value = "paymentServicePointcut()", throwing = "error")
    public void afterThrowingAdvice(JoinPoint jp, Throwable error){
        logger.error(error.getMessage() + " with class " + jp.getSignature().getDeclaringTypeName() + " with method " + jp.getSignature().getName());
    }

}
