package com.sist.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass2 {
	public static void main(String[] args) {
		GenericApplicationContext app=new GenericXmlApplicationContext("app2.xml");
		Board b=app.getBean("board", Board.class);
		b.list();
		b.insert();
		app.close();
	}
}
