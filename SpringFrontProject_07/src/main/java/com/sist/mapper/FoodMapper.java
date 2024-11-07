package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno, name, poster, phone, score, type, hit, num "
			+ "FROM (SELECT fno, name, poster, phone, score, type, hit, rownum as num "
			+ "FROM (SELECT fno, name, poster, phone, score, type, hit "
			+ "FROM project_food_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food_house")
	public int foodTotalPage();
	
	@Update("UPDATE project_food_house SET hit=hit+1 WHERE fno=#{fno}")
	public void foodHitIncrement(int fno);
	
	@Select("SELECT * FROM project_food_house WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	@Select("SELECT COUNT(*) FROM project_member WHERE id=#{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT id, name, sex, pwd FROM project_member "
			+ "WHERE id=#{id}")
	public MemberVO memberInfoData(String id);
}
