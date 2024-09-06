package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDAO {
	@Autowired
	GoodsMapper mapper;
	public List<GoodsVO> goodsListData(Map map) {
		return mapper.goodsListData(map);
	}

	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}

	public GoodsVO goodsDetail(int no) {
		mapper.goodsHitIncrement(no);
		return mapper.goodsDetailData(no);
	}

	public GoodsVO goodsDetailData(int no) {
		return mapper.goodsDetailData(no);
	}
}
