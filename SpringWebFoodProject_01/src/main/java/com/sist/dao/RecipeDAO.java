package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
	@Autowired
	RecipeMapper mapper;
	public List<RecipeVO> recipeListData(Map map){
		return mapper.recipeListData(map);
	}
	
	public int recipeRowCount() {
		return mapper.recipeRowCount();
	}
	
	public RecipeDetailVO recipeDetailData(int no) {
		return mapper.recipeDetailData(no);
	}
}
