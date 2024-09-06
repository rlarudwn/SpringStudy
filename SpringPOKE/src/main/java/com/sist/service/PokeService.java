package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.PokeVO;

public interface PokeService {
	public List<PokeVO> pokeListData(Map map);
	
	public int pokeTotalPage(Map map);
	
	public PokeVO pokeDetailData(int no);
}
