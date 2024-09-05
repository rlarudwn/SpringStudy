package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("SELECT no, goods_name, goods_price, num "
			+ "FROM (SELECT no, goods_name, goods_price, rownum as num "
			+ "FROM (SELECT no, goods_name, goods_price "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE no BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(@Param("start")int start, @Param("end")int end);
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
}
