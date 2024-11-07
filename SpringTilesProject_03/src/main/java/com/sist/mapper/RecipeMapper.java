package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface RecipeMapper {
	@Select("SELECT no, title, chef, poster, num "
			+ "FROM (SELECT no, title, chef, poster, rownum as num "
			+ "FROM (SELECT no, title, chef, poster "
			+ "FROM recipe WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(@Param("start")int start, @Param("end")int end);
	
	@Select("SELECT COUNT(*) FROM recipe WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeTotalPage();
	
	@Select("SELECT * FROM recipedetail WHERE no=#{no}")
	public RecipeVO recipeDetailData(int no);
	
	@Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
	public void recipeHitIncrement(int no);
}
