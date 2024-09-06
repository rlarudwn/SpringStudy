package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("SELECT no, goods_name, goods_poster, num "
			+ "FROM (SELECT no, goods_name, goods_poster, rownum as num "
			+ "FROM (SELECT no, goods_name, goods_poster "
			+ "FROM goods_all)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Update("UPDATE goods_all SET hit=hit+1 WHERE no=#{no}")
	public void goodsHitIncrement(int no);
}
