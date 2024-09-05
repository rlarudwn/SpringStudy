package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO dao;
	public List<FoodVO> foodListData(Map map){
		return dao.foodListData(map);
	}
	public int foodTotalPage() {
		return dao.foodTotalPage();
	}
	
	public FoodVO foodDetail(int fno) {
		return dao.foodDetail(fno);
	}

	public FoodVO foodDetailData(int fno) {
		return dao.foodDetailData(fno);
	}
}
