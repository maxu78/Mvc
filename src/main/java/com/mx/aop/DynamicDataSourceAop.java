package com.mx.aop;

import com.mx.config.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DynamicDataSourceAop {

    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceAop.class);

    public DynamicDataSourceAop(){}

    @Pointcut("@annotation(DataSource)")
    public void aop(){

    }

    @Before("aop()")
    public void before(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        try {
            DataSource dataSource = method.getAnnotation(DataSource.class);
            if (dataSource != null) {
                DynamicDataSource.setDataSourceKey(dataSource.key());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("aop()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long time = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        time = System.currentTimeMillis() - time;
        log.debug("DoAround process time: {} ms", Long.valueOf(time));
        return retVal;
    }

    @After("aop()")
    public void after(JoinPoint jp) {
        log.debug("DoAfter method: {}.{}", jp.getTarget().getClass().getName(),
                jp.getSignature().getName());
    }

    @AfterThrowing(pointcut = "aop()", throwing = "ex")
    public void throwing(JoinPoint jp, Throwable ex) {
        log.debug("DoThrowing method: {}.{} throw exception", jp.getTarget().getClass().getName(), jp.getSignature().getName());
        log.debug("throwable{}", ex);
    }
}
