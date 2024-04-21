package com.project.assignment.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	 @Before("execution(* com.project.assignment.services.BookService.createBook(..)) || " +
             "execution(* com.project.assignment.services.BookService.updateBook(..)) || " +
             "execution(* com.project.assignment.services.BorrowingRecordService.borrowABook(..)) || " +
             "execution(* com.project.assignment.services.BorrowingRecordService.returnABook(..))")
	 public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("Method called: " + joinPoint.getSignature().getName());
        logger.info("Method called: {}", joinPoint.getSignature().getName());
    }
	 
	 @AfterThrowing(pointcut = "execution(* com.project.assignment.services.BookService.createBook(..)) || " +
             "execution(* com.project.assignment.services.BookService.updateBook(..)) || " +
             "execution(* com.project.assignment.services.BorrowingRecordService.borrowABook(..)) || " +
             "execution(* com.project.assignment.services.BorrowingRecordService.returnABook(..))",
             	throwing = "exception")
	    public void logException(JoinPoint joinPoint, Exception exception) {
		 	System.out.println("Exception thrown in " + joinPoint.getSignature().getName() + "() with cause - " + exception.getMessage());
	        logger.error("Exception thrown in {}() with cause - {}", joinPoint.getSignature().getName(), exception.getMessage());
	 }
	 
	 @Around("execution(* com.project.assignment.services.BookService.createBook(..)) || " +
             "execution(* com.project.assignment.services.BookService.updateBook(..)) || " +
             "execution(* com.project.assignment.services.BorrowingRecordService.borrowABook(..)) || " +
             "execution(* com.project.assignment.services.BorrowingRecordService.returnABook(..))")
	    public Object logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
	        StopWatch stopWatch = new StopWatch();
	        stopWatch.start();
	        Object result = joinPoint.proceed();
	        stopWatch.stop();
	        logger.info("Execution time of {}(): {} ms", joinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
	        System.out.println("Execution time of " + joinPoint.getSignature().getName() + "(): " + stopWatch.getTotalTimeMillis() + " ms");
	        return result;
	    }

}
