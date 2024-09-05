package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.PokeMapper;
import com.sist.vo.PokeVO;

@Repository
public class PokeDAO {
	@Autowired
	PokeMapper mapper;
	public List<PokeVO> pokeListData(Map map){
		return mapper.pokeListData(map);
	}
	
	public int pokeTotalPage(Map map){
		return mapper.pokeTotalPage(map);
	}
	
	public PokeVO pokeDetailData(int no) {
		return mapper.pokeDetailData(no);
	}
}
