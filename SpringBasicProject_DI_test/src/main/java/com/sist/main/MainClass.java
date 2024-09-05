package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		GoodsDAO dao=app.getBean("dao", GoodsDAO.class);
		Scanner sc=new Scanner(System.in);
		System.out.print("������ �Է� : ");
		int page=sc.nextInt();
		int start=(page-1)*15+1;
		int end=start+15-1;
		List<GoodsVO> list=dao.goodsListData(start, end);
		for(GoodsVO vo:list) {
			System.out.println("��ǰ��ȣ : "+vo.getNo());
			System.out.println("��ǰ�� : "+vo.getGoods_name());
			System.out.println("��ǰ���� : "+vo.getGoods_price());
			System.out.println("================================");
		}
		System.out.print("��ǰ��ȣ ����");
		int no=sc.nextInt();
		GoodsVO vo=dao.goodsDetailData(no);
		System.out.println("��ǰ��ȣ : "+vo.getNo());
		System.out.println("��ǰ�� : "+vo.getGoods_name());
		System.out.println("��ǰ���� : "+vo.getGoods_sub());
		System.out.println("��ǰ���� : "+vo.getGoods_price());
		System.out.println("��ۺ� : "+vo.getGoods_delivery());
		System.out.println("��ȸ�� : " +vo.getHit());
		
	}
}
