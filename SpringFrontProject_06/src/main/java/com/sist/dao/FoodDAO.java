package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodTypeListData(Map map){
		return mapper.foodTypeListData(map);
	}
	
	public int foodTypeTotalPage(Map map) {
		return mapper.foodTypeTotalPage(map);
	}
	
	public FoodVO foodDetailData(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	
	public List<FoodVO> foodNearListData(String address){
		return mapper.foodNearListData(address);
	}
}
