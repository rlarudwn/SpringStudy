package com.sist.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;
@Component("mc")
public class MainClass {
	@Autowired
	GoodsDAO dao;
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application_*.xml");
		MainClass mc =app.getBean("mc", MainClass.class);
		String[] tables = { "", "goods_all", "goods_best", "goods_new", "goods_special" };
		Scanner sc = new Scanner(System.in);
		System.out.print("1. ��ü��ǰ, 2.�α��ǰ, 3.�űԻ�ǰ, 4.Ư����ǰ");
		int cno = sc.nextInt();
		System.out.print("������ ����");
		int page = sc.nextInt();
		int start = (page - 1) * 20 + 1;
		int end = start + 20 - 1;
		
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("table_name", tables[cno]);
		List<GoodsVO> list=mc.dao.goodsListData(map);
		for(GoodsVO vo:list) {
			System.out.println(vo.getNo()+". " +vo.getGoods_name());
		}
		System.out.println("=========================================");
		System.out.print("��ǰ��ȣ ����");
		int no=sc.nextInt();
		map.put("no", no);
		GoodsVO vo=mc.dao.goodsDetailData(map);
		System.out.println("��ǰ��ȣ : "+vo.getNo());
		System.out.println("��ǰ�� : "+vo.getGoods_name());
		System.out.println("��ǰ���� : "+vo.getGoods_price());
		System.out.println("��ǰ�Ұ� : "+vo.getGoods_sub());
	}
}
