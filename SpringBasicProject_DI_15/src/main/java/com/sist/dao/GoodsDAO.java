package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;

@Repository("dao")
public class GoodsDAO {
	@Autowired
	GoodsMapper mapper;
	public List<GoodsVO> goodsListData(Map map){
		return mapper.goodsListData(map);
	}
	
	public int goodsTotalPage(Map map) {
		return mapper.goodsTotalPage(map);
	}
	
	public GoodsVO goodsDetailData(Map map) {
		return mapper.goodsDetailData(map);
	}
	
}
