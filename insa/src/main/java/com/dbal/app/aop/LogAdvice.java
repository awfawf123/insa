package com.dbal.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component //<bean> 등록
@Aspect //<aop:aspect>
public class LogAdvice {
	@Pointcut("execution(public * com.dbal.app..*Impl.*(..))")
	public void allpointcut() {}
	
	@Before("allpointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] param = jp.getArgs();
		System.out.println("[공통로그] before" + method + "\n" + ((param !=null)? param[0] : ""));
	}

}
