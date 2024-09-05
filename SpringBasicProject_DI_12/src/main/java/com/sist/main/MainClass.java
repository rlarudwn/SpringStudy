package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		FoodDAO dao=app.getBean("dao", FoodDAO.class);
		Scanner scanner=new Scanner(System.in);
		System.out.print("������ �Է� : ");
		int page=scanner.nextInt();
		int start=(page-1)*10+1;
		int end=start+10-1;
		int totalPage=dao.foodTotalPage();
		List<FoodVO> list=dao.foodListData(start, end);
		for(FoodVO vo:list) {
			System.out.println("��ü��ȣ : " + vo.getFno());
			System.out.println("��ü�� : " + vo.getName());
			System.out.println("=======================================================");
		}
		System.out.println("====="+page+"page/"+totalPage+"page=====");
		System.out.print("��ü��ȣ �Է�");
		int fno=scanner.nextInt();
		FoodVO vo=dao.foodDetailData(fno);
		System.out.println("=============��ü ����=============");
		System.out.println("��ü��ȣ : " + vo.getFno());
		System.out.println("��ü�� : " + vo.getName());
		System.out.println("�ּ� : " + vo.getAddress());
		System.out.println("��ȭ : " + vo.getPhone());
		System.out.println("�������� : " + vo.getType());
		System.out.println("�����ð� : " + vo.getTime());
		System.out.println("���� : " + vo.getParking());
		System.out.println("�׸� : " + vo.getTheme());
		System.out.println("���� : " + vo.getScore());
	}
}
