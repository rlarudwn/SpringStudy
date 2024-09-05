package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
// ������	=> �޸� �Ҵ��� �� �� ����
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
			System.out.println("��û�� �޼ҵ� : "+jp.getSignature().getName());
			System.out.println("ó�� �ҿ� �ð� : "+(end-start));
		} catch (Throwable e) {}
		return obj;
	}
}
