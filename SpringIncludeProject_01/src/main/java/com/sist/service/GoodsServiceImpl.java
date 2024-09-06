package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDAO dao;
	public List<GoodsVO> goodsListData(Map map){
		return dao.goodsListData(map);
	}
	public int goodsTotalPage() {
		return dao.goodsTotalPage();
	}
	public GoodsVO goodsDetail(int no) {
		return dao.goodsDetail(no);
	}
	public GoodsVO goodsDetailData(int no) {
		return dao.goodsDetailData(no);
	}
}
