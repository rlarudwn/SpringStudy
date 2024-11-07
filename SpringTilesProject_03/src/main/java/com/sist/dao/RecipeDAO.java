package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	public List<RecipeVO> recipeListData(int start,int end){
		return mapper.recipeListData(start, end);
	}
	
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	
	public RecipeVO recipeDetailData(int no) {
		return mapper.recipeDetailData(no);
	}
	
	public void recipeHitIncrement(int no) {
		mapper.recipeHitIncrement(no);
	}
}
