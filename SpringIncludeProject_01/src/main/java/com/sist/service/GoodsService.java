package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.GoodsVO;

public interface GoodsService {
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
	public GoodsVO goodsDetail(int no);
	public GoodsVO goodsDetailData(int no);
}
