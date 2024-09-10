package com.sist.tmp;

import com.sist.vo.InputVO;
import com.sist.vo.StoreVO;

public class MainClass {
	public static void main(String[] args) {
		InputVO ivo=new InputVO();
		ivo.setNo(3);
		ivo.setGno(10);
		ivo.setPrice(10000);
		
		StoreVO svo=new StoreVO();
		svo.setNo(1);
		svo.setGno(10);
		svo.setPrice(10000);
		
		GoodsDAO dao=new GoodsDAO();
		dao.insert(svo, ivo);
	}
}
