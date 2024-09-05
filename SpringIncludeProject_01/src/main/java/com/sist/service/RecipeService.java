package com.sist.service;

import java.util.*;

import com.sist.vo.*;

public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeRowCount();
	public RecipeDetailVO recipeDetailData(int no);
	public List<ChefVO> chefListData(Map map);
	public int chefRowCount();
	public int chefRecipeRowCount(Map map);
	public List<RecipeVO> chefRecipeListData(Map map);
	public RecipeVO recipeCookieData(int no);
}	
