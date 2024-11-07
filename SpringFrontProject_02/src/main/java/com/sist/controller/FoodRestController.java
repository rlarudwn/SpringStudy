package com.sist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;

	@GetMapping(value = "food/listVue.do", produces = "text/plain;charset=UTF-8")
	public String foodVueList(int page) throws Exception {
		String json = "";
		int start = (page - 1) * 12 + 1;
		int end = start + 12 - 1;
		int startPage = (page - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		int totalPage = dao.foodTotalPage();
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list = dao.foodListData(map);
		if (endPage > totalPage)
			endPage = totalPage;
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("curPage", page);
		map.put("list", list);
		ObjectMapper mapper=new ObjectMapper();
		json=mapper.writeValueAsString(map);
		return json;
	}
}
