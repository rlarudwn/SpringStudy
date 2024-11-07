package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import java.util.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeMaxHitData(){
		return mapper.recipeMaxHitData();
	}
	
	public List<RecipeVO> recipeHitTop(){
		return mapper.recipeHitTop();
	}
	
	public List<RecipeVO> recipeListData(Map map){
		return mapper.recipeListData(map);
	}
	
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	
	public RecipeDetailVO recipeDetail(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
}
