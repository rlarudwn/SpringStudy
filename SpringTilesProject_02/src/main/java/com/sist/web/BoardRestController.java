package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@RestController
public class BoardRestController {
	@Autowired
	BoardDAO dao;
	@GetMapping(value = "board/listVue.do", produces = "text/plain;charset=UTF-8")
	public String listVue(int page) {
		String json = "";
		int rowSize=10;
		int start=(page-1)*rowSize+1;
		int end=start+rowSize-1;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		int count=dao.boardRowCount();
		int totalPage=(int)(Math.ceil(count/10.0));
		count=count-(page-1)*rowSize;
		Map map2 = new HashMap();
		map2.put("curPage", page);
		map2.put("totalPage", totalPage);
		map2.put("count", count);
		map2.put("list", list);
		ObjectMapper mapper=new ObjectMapper();
		try {
			json=mapper.writeValueAsString(map2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
