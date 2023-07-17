package com.kjczwl.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/***
* @Description: AspectLogController
* @Author: Mr.Tang
* @Date: 2022/10/9
*/
@Aspect
@Component
@Slf4j
public class AspectLogController {

    @Before("execution(* com.kjczwl.*.controller.*.*(..))")
    public void permissionCheck(JoinPoint point) {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] strings = methodSignature.getParameterNames();
        Object[] args = point.getArgs();
        log.info(point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + Arrays.toString(strings) + Arrays.toString(args));
    }
}
