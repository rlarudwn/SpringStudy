package com.sist.service;

import java.util.List;


import com.sist.vo.RecipeVO;

public interface RecipeService {

	public List<RecipeVO> recipeListData(int start,int end);
	public int recipeTotalPage();
	public RecipeVO recipeDetail(int no);
}
