package com.sist.dao;

import org.aspectj.lang.ProceedingJoinPoint;

public class DAOAop {
	public void before() {
		System.out.println("오라클 연결");
	}

	public void after() {
		System.out.println("오라클 해제");
	}

	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		long start = System.currentTimeMillis();
		System.out.println("호출된 메소드" + jp.getSignature().getName());
		obj = jp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end - start));
		return obj;
	}

	public void afterReturning(Object obj) {
		System.out.println("====== 결과값 자동 처리 ======");
		System.out.println("결과값 : "+obj);
	}
	public void afterThrowing(Throwable e) {
		System.out.println("===== 예외발생 =====");
		System.out.println("에러 : "+e);
	}
}
