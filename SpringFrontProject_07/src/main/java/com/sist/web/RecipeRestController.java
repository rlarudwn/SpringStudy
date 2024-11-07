package com.sist.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

@RestController
public class RecipeRestController {
	@Autowired
	private RecipeDAO dao;

	@GetMapping(value = "recipe/vueList.do", produces = "text/plain;charset=UTF-8")
	public String recipeVueList(int page) throws Exception {
		Map map = new HashMap();
		int rowSize = 12;
		int start = (page - 1) * rowSize + 1;
		int end = start + rowSize - 1;
		map.put("start", start);
		map.put("end", end);
		List<RecipeVO> list = dao.recipeListData(map);
		int totalPage = dao.recipeTotalPage();
		final int BLOCK = 10;
		int startPage = (page - 1) / BLOCK * BLOCK + 1;
		int endPage = startPage + BLOCK - 1;
		if (endPage > totalPage)
			endPage = totalPage;
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("curPage", page);
		map.put("totalPage", totalPage);
		map.put("list", list);
		JsonMapper mapper = new JsonMapper();
		String json = mapper.writeValueAsString(map);
		return json;
	}

	@GetMapping(value = "recipe/vueDetail.do", produces = "text/plain;charset=UTF-8")
	public String recipeVueDetail(int no) throws Exception{
		RecipeDetailVO vo = dao.recipeDetail(no);
		vo.setData(vo.getData().replace("±¸¸Å", ""));
		List<String> iList = new ArrayList<String>();
		List<String> sList = new ArrayList<String>();
		for (String s : vo.getFoodmake().split("\n")) {
			StringTokenizer st = new StringTokenizer(s, "^");
			sList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		Map map=new HashMap();
		map.put("detail", vo);
		map.put("iList", iList);
		map.put("sList", sList);
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
