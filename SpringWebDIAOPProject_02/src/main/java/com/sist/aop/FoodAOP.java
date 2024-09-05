package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
// 공통모듈	=> 메모리 할당은 할 수 없다
@Aspect
@Component
public class FoodAOP {
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object log(ProceedingJoinPoint jp) {
		Object obj=null;
		try {
			long start=System.currentTimeMillis();
			obj=jp.proceed();
			long end=System.currentTimeMillis();
			System.out.println("요청한 메소드 : "+jp.getSignature().getName());
			System.out.println("처리 소요 시간 : "+(end-start));
		} catch (Throwable e) {}
		return obj;
	}
}
