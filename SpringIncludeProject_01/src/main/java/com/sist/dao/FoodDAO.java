package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;
@Repository
public class FoodDAO {
	@Autowired
	FoodMapper mapper;

	public List<FoodVO> foodListData(Map map) {
		return mapper.foodListData(map);
	}

	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}

	public FoodVO foodDetail(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}

	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}

}
