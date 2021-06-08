package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")//수식은 검색으로 알아보셈
    private void cut(){}

    @Before("cut()")//cut()메서드가 실행하는시점 이전에 @Before에 해당하는 메서드를 실행
    public void before(JoinPoint joinpoint){
        Object[] args = joinpoint.getArgs();
        MethodSignature methodSignature = (MethodSignature)joinpoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        for(Object obj : args){
            System.out.println("type: " + obj.getClass().getSimpleName());
            System.out.println("value: " + obj);

        }
    }//메서드가 실행하기전에 argument를 확인하기위해

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinpoint, Object returnObj){
        System.out.println("returnObj");
        System.out.println(returnObj);
    }//
}
