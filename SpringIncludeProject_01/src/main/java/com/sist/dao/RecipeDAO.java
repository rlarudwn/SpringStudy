package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	public List<RecipeVO> recipeListData(Map map){
		return mapper.recipeListData(map);
	}
	
	public int recipeRowCount() {
		return mapper.recipeRowCount();
	}

	public RecipeDetailVO recipeDetailData(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
	
	public List<ChefVO> chefListData(Map map){
		return mapper.chefListData(map);
	}
	
	public int chefRowCount() {
		return mapper.chefRowCount();
	}
	
	public List<RecipeVO> chefRecipeListData(Map map){
		return mapper.chefRecipeListData(map);
	}
	
	public int chefRecipeRowCount(Map map) {
		return mapper.chefRecipeRowCount(map);
	}
	
	public RecipeVO recipeCookieData(int no) {
		return mapper.recipeCookieData(no);
	}
}
