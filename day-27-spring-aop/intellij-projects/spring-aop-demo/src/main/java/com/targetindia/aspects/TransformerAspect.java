package com.targetindia.aspects;

import com.targetindia.dao.DaoException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransformerAspect {

    @AfterThrowing(pointcut = "execution (* com..dao.*Dao.*(..))", throwing = "e")
    void toDaoException(Exception e) {
        throw new DaoException(e);
    }


    @Around("execution(* com..dao.*Dao.*(double, double))")
    public Object swapArgs(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        double d1 = (double) args[0];
        double d2 = (double) args[1];
        if (d1 > d2) {
            args = new Object[]{d2, d1};
        }
        // did something before the method call
        Object retVal = jp.proceed(args); // actual target method call
        // do something after the method call is over
        return retVal;
    }

}
