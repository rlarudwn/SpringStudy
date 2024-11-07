package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodListData(Map map){
		return mapper.foodListData(map);
	}
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	public List<FoodVO> foodFindListData(Map map){
		return mapper.foodFindListData(map);
	}
	public int foodFindTotalPage(Map map) {
		return mapper.foodFindTotalPage(map);
	}
}
