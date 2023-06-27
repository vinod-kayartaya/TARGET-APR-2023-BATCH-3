package com.targetindia.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Component
@Aspect // spring-aop scans all @Aspect beans in the container and goes through all the advices to create a proxy
@Slf4j
public class LoggerAspect {
    public LoggerAspect() {
        log.trace("LoggerAspect constructor called");
    }

    @Pointcut("execution(* com..dao.*Dao.*(..))")
    public void pc1(){}

    // one or more advices
    @Before("pc1()")
    public void logMethodEntry(JoinPoint jp){
        log.trace("execution of {}.{}({}) on an object of {} class started",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                arrayToString(jp.getArgs()),
                jp.getTarget().getClass().getName()
                );
    }

    @After("pc1()")
    public void logMethodExit(JoinPoint jp){
        log.trace("completed the execution of {}.{}({}) on an object of {} class",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                arrayToString(jp.getArgs()),
                jp.getTarget().getClass().getName()
        );
    }

    private String arrayToString(Object[] args){
        return Stream.of(args)
                .map(Object::toString)
                .map(s->s.replace("[", ""))
                .map(s->s.replace("]", ""))
                .collect(Collectors.joining(", "));
    }

}
