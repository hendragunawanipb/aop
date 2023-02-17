package com.example.springbootaspect.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogExecutionAspect {

	public static final Logger logger = LoggerFactory.getLogger(LogExecutionAspect.class);

	// types of advice - start
	//@Before("@annotation(com.example.springbootaspect.annotation.LogExecutionTime)")
	//@Before("pointCutB()")
	public void logBefore(JoinPoint joinPoint) {
		logger.debug("Before execution - start:" + joinPoint.getSignature().toShortString());
	}
//execution(* com.example.springbootaspect.adapter..*(..))
	//@After("@annotation(com.example.springbootaspect.annotation.LogExecutionTime)")
	public void logAfter(JoinPoint joinPoint) {
		logger.debug("After execution - end: " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning("@annotation(com.example.springbootaspect.annotation.LogExecutionTime)")
	public void logAfterReturning(JoinPoint joinPoint) {
		logger.debug("@AfterReturning execution - call: ");
	}
	
	@AfterThrowing("@annotation(com.example.springbootaspect.annotation.LogExecutionTime)")
	public void logAfterThrowing(JoinPoint joinPoint) {
		logger.debug("@AfterThrowing execution - call: ");
	}
	
	@Pointcut("@annotation(com.example.springbootaspect.annotation.LogExecutionTime)")
	public void pointCutA() {}
	
	@Pointcut("execution(* com.example.springbootaspect.adapter..*(..))")
	public void pointCutB() {}
	
	//@Around("@annotation(com.example.springbootaspect.annotation.LogExecutionTime)")
	@Around("pointCutA() || pointCutB()")
	public Object logAround(ProceedingJoinPoint point) throws Throwable {
		logger.debug("@Around execution - call: ");
		long startTime = System.currentTimeMillis();
		logger.info("[START]"
				+"|"+ point.getSignature().getDeclaringType().getSimpleName() 
				+"|"+ point.getSignature().getName()
				+"[START]");
		
        Object object = point.proceed();
        
        logger.info("[END]"
				+"|"+ point.getSignature().getDeclaringType().getSimpleName() 
				+"|"+ point.getSignature().getName()
				+"[END]");
        long endtime = System.currentTimeMillis();
        printLog(point, startTime, endtime);
        return object;
	}
	
	// types of advice - end
	
	
	private void printLog(ProceedingJoinPoint point, long startTime, long endtime) {
		logger.debug("ExecutionTime"
					+"|"+ point.getSignature().getDeclaringType().getSimpleName() 
					+"|"+ point.getSignature().getName() 
					+"|"+ (endtime-startTime) +"ms");
	}
	
	
}
