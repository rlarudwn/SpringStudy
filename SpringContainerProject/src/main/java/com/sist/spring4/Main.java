package com.sist.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("applictaion.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println(sa);
		sa.print();
		Sawon sa1=(Sawon)app.getBean("sa");
		Sawon sa2=(Sawon)app.getBean("sa2");
		Sawon sa3=(Sawon)app.getBean("sa");
		Sawon sa4=(Sawon)app.getBean("sa");
		sa1.setDept("¿µ¾÷");
		System.out.println(sa1);
		System.out.println(sa2);
		System.out.println(sa3);
		System.out.println(sa4);
	}
}
