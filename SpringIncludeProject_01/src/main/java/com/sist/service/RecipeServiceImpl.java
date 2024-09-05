package com.sist.service;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO dao;
	public List<RecipeVO> recipeListData(Map map){
		return dao.recipeListData(map);
	}
	@Override
	public int recipeRowCount() {
		return dao.recipeRowCount();
	}
	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		return dao.recipeDetailData(no);
	}
	@Override
	public List<ChefVO> chefListData(Map map) {
		return dao.chefListData(map);
	}
	@Override
	public int chefRowCount() {
		return dao.chefRowCount();
	}
	@Override
	public int chefRecipeRowCount(Map map) {
		return dao.chefRecipeRowCount(map);
	}
	@Override
	public List<RecipeVO> chefRecipeListData(Map map) {
		return dao.chefRecipeListData(map);
	}
	@Override
	public RecipeVO recipeCookieData(int no) {
		return dao.recipeCookieData(no);
	}
}
