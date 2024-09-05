package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
import java.util.*;
public interface RecipeMapper {
	@Select("SELECT no, poster, title, chef, num "
			+ "FROM (SELECT no, poster, title, chef, rownum as num "
			+ "FROM (SELECT /*+INDEX_ASC(recipe recipe_no_pk)*/ no, poster, title, chef "
			+ "FROM recipe WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT COUNT(*) FROM recipe WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeRowCount();
	
	@Select("SELECT * FROM recipedetail WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	@Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT chef, poster, mem_cont1, mem_cont3, mem_cont7, mem_cont2, num "
			+ "FROM (SELECT chef, poster, mem_cont1, mem_cont3, mem_cont7, mem_cont2, rownum as num "
			+ "FROM (SELECT /*+INDEX_ASC(chef chef_chef_pk)*/ chef, poster, mem_cont1, mem_cont3, mem_cont7, mem_cont2 "
			+ "FROM chef)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT COUNT(*) FROM chef")
	public int chefRowCount();
	
	@Select("SELECT no, poster, title, chef, num "
			+ "FROM (SELECT no, poster, title, chef, rownum as num "
			+ "FROM (SELECT /*+INDEX_ASC(recipe recipe_no_pk)*/ no, poster, title, chef "
			+ "FROM recipe WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail) AND chef=#{chef})) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> chefRecipeListData(Map map);
	
	@Select("SELECT COUNT(*) FROM recipe WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail) AND chef=#{chef}")
	public int chefRecipeRowCount(Map map);
	
	@Select("SELECT no, title, poster FROM recipe WHERE no=#{no}")
	public RecipeVO recipeCookieData(int no);
}
