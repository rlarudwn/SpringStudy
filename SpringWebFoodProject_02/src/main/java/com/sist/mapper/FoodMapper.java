package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno, name, poster, num "
			+ "FROM (SELECT fno, name, poster, rownum as num "
			+ "FROM (SELECT /*+INDEX_ASC(project_food_house FH_FNO_PK)*/ fno, name, poster "
			+ "FROM project_food_house)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
	public int foodTotalPage();
	
	@Select("SELECT * FROM project_food_house WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
