package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno, name, poster, type, num "
			+ "FROM (SELECT fno, name, poster, type, rownum as num "
			+ "FROM (SELECT fno, name, poster, type "
			+ "FROM project_food_house WHERE type LIKE '%'||#{type}||'%' ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodTypeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house WHERE type LIKE '%'||#{type}||'%'")
	public int foodTypeTotalPage(Map map);
	
	@Update("UPDATE project_food_house SET hit=hit+1 WHERE fno=#{fno}")
	public void foodHitIncrement(int fno);
	
	@Select("SELECT fno, name, poster, type, hit, phone, address, theme, images, time, parking, content, score "
			+ "FROM project_food_house WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	@Select("SELECT fno, name, poster, address, rownum "
			+ "FROM (SELECT fno, name, poster, address "
			+ "FROM project_food_house WHERE address LIKE '%'||#{address}||'%' ORDER BY hit DESC )"
			+ "WHERE rownum<=5")
	public List<FoodVO> foodNearListData(String address);
	
}
