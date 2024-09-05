package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface PokeMapper {
	@Select("SELECT no, name, poster, form, num "
			+ "FROM (SELECT no, name, poster, form, rownum as num "
			+ "FROM (SELECT no, name, poster, form "
			+ "FROM poke WHERE name LIKE '%'||#{ss}||'%' ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<PokeVO> pokeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM poke WHERE name LIKE '%'||#{ss}||'%'")
	public int pokeTotalPage(Map map);
	
	@Select("SELECT * FROM poke WHERE no=#{no}")
	public PokeVO pokeDetailData(int no);
}
