package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	RecipeDAO dao;

	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		return dao.recipeListData(start, end);
	}

	@Override
	public int recipeTotalPage() {
		return dao.recipeTotalPage();
	}

	@Override
	public RecipeVO recipeDetail(int no) {
		dao.recipeHitIncrement(no);
		return dao.recipeDetailData(no);
	}
}
