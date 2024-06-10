package ru.goryacheva.springaophw.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.goryacheva.springaophw.util.exception.TrackTimeException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@Aspect
@Slf4j
public class AsyncTrackTimeAspect {

    @Pointcut("execution(@ru.goryacheva.springaophw.annotation.TrackAsyncTime public Long addAsync(..))")
    public void asyncTrackTimePointcut() {
    }

    @Around("asyncTrackTimePointcut()")
    public Object asyncTrackTime(ProceedingJoinPoint joinPoint) {

        try {
            return CompletableFuture.supplyAsync(() -> {

                try {
                    long startTime = System.currentTimeMillis();

                    String methodName = joinPoint.getSignature().getName();

                    log.info("Метод {} начал выполнение", methodName);

                    Object target = joinPoint.proceed();

                    long endTime = System.currentTimeMillis();

                    target = endTime - startTime;

                    log.info("Метод {} выполнился за {}", methodName, target);

                    return target;

                } catch (Throwable e) {
                    throw new TrackTimeException("Ошибка AsyncRunnerAspect", e);
                }

            }).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new TrackTimeException("Ошибка при получении результата в AsyncRunnerAspect", e);
        }
    }
}
