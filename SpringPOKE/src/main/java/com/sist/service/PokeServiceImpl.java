package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.PokeDAO;
import com.sist.vo.PokeVO;

@Service
public class PokeServiceImpl implements PokeService {
	@Autowired
	PokeDAO dao;

	public List<PokeVO> pokeListData(Map map) {
		return dao.pokeListData(map);
	}

	public int pokeTotalPage(Map map) {
		return dao.pokeTotalPage(map);
	}

	public PokeVO pokeDetailData(int no) {
		return dao.pokeDetailData(no);
	}

	@Override
	public List<PokeVO> pokeTypeListData(Map map) {
		return dao.pokeTypeListData(map);
	}

	@Override
	public int pokeTypeTotalPage(Map map) {
		return dao.pokeTypeTotalPage(map);
	}
}
