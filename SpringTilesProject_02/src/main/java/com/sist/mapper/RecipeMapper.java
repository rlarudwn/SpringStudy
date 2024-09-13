package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
public interface RecipeMapper {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeRowCount();
	public List<RecipeVO> recipeFindListData(Map map);
	public int recipeFindRowCount(Map map);
	public RecipeDetailVO recipeDetailData(int no);
	public void recipeHitIncrement(int no);
	public List<ChefVO> chefListData(Map map);
	public List<RecipeVO> chefRecipeListData(Map map);
	public int chefRowCount();
	public int chefRecipeRowCount(Map map);
}