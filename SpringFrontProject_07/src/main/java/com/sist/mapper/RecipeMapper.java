package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface RecipeMapper {
	@Select("SELECT no, title, poster, chef, hit, "
			+ "(SELECT content FROM recipedetail WHERE no=recipe.no) as content "
			+ "FROM recipe "
			+ "WHERE hit=(SELECT max(hit) FROM recipe)")
	public List<RecipeVO> recipeMaxHitData();
	
	@Select("SELECT no, title, poster, chef, hit, content, rownum "
			+ "FROM (SELECT no, title, poster, chef, hit, "
			+ "(SELECT content FROM recipedetail WHERE no=recipe.no) as content "
			+ "FROM recipe ORDER BY hit DESC) WHERE rownum <= 8 AND hit!=(SELECT max(hit) FROM recipe)")
	public List<RecipeVO> recipeHitTop();
	
	@Select("SELECT no, poster, title, chef, hit, num "
			+ "FROM (SELECT no, poster, title, chef, hit, rownum as num "
			+ "FROM (SELECT no, poster, title, chef, hit "
			+ "FROM recipe "
			+ "WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail) "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeTotalPage();
	
	@Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT * FROM recipedetail WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
}

