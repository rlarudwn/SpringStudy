package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

@Component("mc")
public class Main2 {
	@Autowired
	@Qualifier("Oracle")
	private MyDAO dao;
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application_*.xml");
		Main2 mc=app.getBean("mc", Main2.class);
		mc.dao.connection();
	}
}
