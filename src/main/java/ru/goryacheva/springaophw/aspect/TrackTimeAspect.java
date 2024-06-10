package ru.goryacheva.springaophw.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TrackTimeAspect {

    @Pointcut("execution(@ru.goryacheva.springaophw.annotation.TrackTime public Long add(..))")
    public void trackTimePointcut(){
    }

    @Around(value = "trackTimePointcut()")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().getName();

        Object target = joinPoint.proceed();

        log.info("Метод {} начал выполнение", methodName);

        joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        target = endTime - startTime;

        log.info("Метод {} выполнился за {}", methodName, target);


        return target;
    }
}
