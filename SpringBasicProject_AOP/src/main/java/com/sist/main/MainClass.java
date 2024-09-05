package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=app.getBean("empDAO", EmpDAO.class);
		dao.empListData();
	}
}
