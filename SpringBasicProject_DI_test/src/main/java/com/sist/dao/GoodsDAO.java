package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;
@Repository("dao")
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	public List<GoodsVO> goodsListData(int start, int end) {
		return mapper.goodsListData(start, end);
	}
	public GoodsVO goodsDetailData(int no) {
		return mapper.goodsDetailData(no);
	}
}
