package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=app.getBean("dao", MyDAO.class);
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		System.out.println(dao.find("hi"));
		
	}
}
