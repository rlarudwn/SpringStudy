package com.sist.dao;

import org.aspectj.lang.ProceedingJoinPoint;

public class DAOAop {
	public void before() {
		System.out.println("����Ŭ ����");
	}

	public void after() {
		System.out.println("����Ŭ ����");
	}

	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		long start = System.currentTimeMillis();
		System.out.println("ȣ��� �޼ҵ�" + jp.getSignature().getName());
		obj = jp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("�ҿ�ð� : " + (end - start));
		return obj;
	}

	public void afterReturning(Object obj) {
		System.out.println("====== ����� �ڵ� ó�� ======");
		System.out.println("����� : "+obj);
	}
	public void afterThrowing(Throwable e) {
		System.out.println("===== ���ܹ߻� =====");
		System.out.println("���� : "+e);
	}
}