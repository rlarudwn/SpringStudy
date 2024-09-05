package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDAO2;
import com.sist.vo.EmpVO;

public class Main2 {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
		EmpDAO2 dao = app.getBean("dao2", EmpDAO2.class);
		List<EmpVO> list = dao.empListData();
		for (EmpVO vo : list) {
			System.out.println(vo.getEmpno());
		}
	}

}
