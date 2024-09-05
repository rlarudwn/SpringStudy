package com.sist.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("�޴� ����(�̸��˻� (1), �ּ� �˻�(2), �������� ����(3)):");
		int menu=sc.nextInt();
		String column="";
		if(menu==1)
			column="name";
		else if(menu==2)
			column="address";
		else if(menu==3)
			column="type";
		System.out.print("�˻��� �Է� : ");
		String fd=sc.next();
		Map map=new HashMap();
		map.put("column", column);
		map.put("fd", fd);
		ApplicationContext app=new ClassPathXmlApplicationContext("application_*.xml");
		FoodDAO dao=app.getBean("dao", FoodDAO.class);
		List<FoodVO> list=dao.foodFindData(map);
		for(FoodVO vo:list) {
			System.out.println(vo.getName());
		}
	}
}
