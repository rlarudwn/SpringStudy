package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

@Component
public class EmpAOP {
	@Autowired
	private EmpDAO dao;
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void getConnection() {
		dao.getConnection();
	}
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void disConnection() {
		dao.disConnection();
	}
	@Around("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public Object log(ProceedingJoinPoint jp){
		Object obj=null;
		try {
			long start=System.currentTimeMillis();
			obj=jp.proceed();
			System.out.println("호출된 메소드 : "+jp.getSignature().getName());
			long end=System.currentTimeMillis();
			System.out.println("소요시간 : "+(end-start));
		} catch (Throwable e) {}
		return obj;
	}
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp*())", returning = "obj")
	public void afterReturning(Object obj) {
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo : list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getHiredate().toString()+" "+vo.getSal());
		}
	}
	@AfterThrowing(value = "execution(* com.sist.dao.EmpDAO.emp*(..))", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("======== 오류 발생 ========");
		e.printStackTrace();
	}
}
