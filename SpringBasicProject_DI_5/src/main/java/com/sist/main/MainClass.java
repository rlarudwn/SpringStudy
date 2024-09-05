package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.BoardDAO;
import com.sist.manager.BoardManager;
import com.sist.model.BoardModel;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		BoardDAO dao=app.getBean("dao", BoardDAO.class);
		dao.list();
		BoardManager bm=app.getBean("bm", BoardManager.class);
		bm.manager();
		//id지정 안된 경우 : 자동 지정(클래스명이 아이디	=> 첫글자 소문자)
		BoardModel bModel=app.getBean("boardModel", BoardModel.class);
		bModel.model();
	}
}
