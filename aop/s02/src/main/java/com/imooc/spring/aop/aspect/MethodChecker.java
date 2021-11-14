package com.imooc.spring.aop.aspect;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MethodChecker {
    //ProceedingJoinPoint是JoinPoin的升级版，在原有功能外，还可以控制目标方法是否运行
    public  Object check(ProceedingJoinPoint pjp) throws Throwable {
        try {
            long startTime = new Date().getTime();
            Object ret = pjp.proceed();//执行目标方法,方法返回后的值
            long endTime = new Date().getTime();
            long duration = endTime - startTime;
            if (duration >= 1000) {
                String className = pjp.getTarget().getClass().getName();//获取目标类的名称
                String methodName = pjp.getSignature().getName();//获取目标方法的名称
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                String now = sdf.format(new Date());
                System.out.println("----------->" + now + ":" + className + "." + methodName);
            }
            return ret;
        } catch (Throwable e) {
            System.out.println("Exception message " + e.getMessage());
            throw e;
        }
    }
}
