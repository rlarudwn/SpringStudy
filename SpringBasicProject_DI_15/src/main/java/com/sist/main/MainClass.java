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
		System.out.print("1. 전체상품, 2.인기상품, 3.신규상품, 4.특가상품");
		int cno = sc.nextInt();
		System.out.print("페이지 선택");
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
		System.out.print("상품번호 선택");
		int no=sc.nextInt();
		map.put("no", no);
		GoodsVO vo=mc.dao.goodsDetailData(map);
		System.out.println("상품번호 : "+vo.getNo());
		System.out.println("상품명 : "+vo.getGoods_name());
		System.out.println("상품가격 : "+vo.getGoods_price());
		System.out.println("상품소개 : "+vo.getGoods_sub());
	}
}
