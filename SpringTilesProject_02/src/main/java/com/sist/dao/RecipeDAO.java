package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.*;

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
	
	public RecipeDetailVO recipeDetail(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
	
	public List<RecipeVO> recipeFindListData(Map map){
		return mapper.recipeFindListData(map);
	}
	
	public int recipeFindRowCount(Map map) {
		return mapper.recipeFindRowCount(map);
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
}
