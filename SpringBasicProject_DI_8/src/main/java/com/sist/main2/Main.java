package com.sist.main2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		EmpDAO dao=app.getBean("dao", EmpDAO.class);
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEname());
		}
	}
}
