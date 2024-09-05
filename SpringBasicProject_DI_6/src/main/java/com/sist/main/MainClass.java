package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=app.getBean("dao", EmpDAO.class);
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getHiredate().toString()+" "+vo.getSal());
		}
	}
}
