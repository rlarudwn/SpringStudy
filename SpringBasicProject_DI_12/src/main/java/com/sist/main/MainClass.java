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
		System.out.print("페이지 입력 : ");
		int page=scanner.nextInt();
		int start=(page-1)*10+1;
		int end=start+10-1;
		int totalPage=dao.foodTotalPage();
		List<FoodVO> list=dao.foodListData(start, end);
		for(FoodVO vo:list) {
			System.out.println("업체번호 : " + vo.getFno());
			System.out.println("업체명 : " + vo.getName());
			System.out.println("=======================================================");
		}
		System.out.println("====="+page+"page/"+totalPage+"page=====");
		System.out.print("업체번호 입력");
		int fno=scanner.nextInt();
		FoodVO vo=dao.foodDetailData(fno);
		System.out.println("=============업체 정보=============");
		System.out.println("업체번호 : " + vo.getFno());
		System.out.println("업체명 : " + vo.getName());
		System.out.println("주소 : " + vo.getAddress());
		System.out.println("전화 : " + vo.getPhone());
		System.out.println("음식종류 : " + vo.getType());
		System.out.println("영업시간 : " + vo.getTime());
		System.out.println("주차 : " + vo.getParking());
		System.out.println("테마 : " + vo.getTheme());
		System.out.println("평점 : " + vo.getScore());
	}
}
