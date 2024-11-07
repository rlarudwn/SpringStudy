package com.sist.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.PokeService;
import com.sist.vo.PokeVO;

@RestController
public class PokeRestController {
	String[] types = { "강철", "격투", "고스트", "노말", "독", "드래곤", "땅", "물", "바위", "벌레", "불꽃", "비행", "악", "얼음", "에스퍼", "전기",
			"페어리", "풀" };
	@Autowired
	PokeService pService;

	@GetMapping(value = "poke/list2.do", produces = "text/plain;charset=UTF-8")
	public String pokeListData(int page, String ss, String type) {
		List<PokeVO> list =new ArrayList<PokeVO>();
		int totalPage=0;
		String json = "";
		int count=0;
		if(type.length()>0) {
			count = type.split("\\|", -1).length;
		}
		if (ss == null)
			ss = "";
		int start = (page - 1) * 12 + 1;
		int end = start + 12 - 1;
		Map map1 = new HashedMap();
		Map map2 = new HashedMap();
		map1.put("start", start);
		map1.put("end", end);
		map1.put("ss", ss);
		map1.put("type", type);
		int startPage = (page - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		if(count<=1) {
			list = pService.pokeListData(map1);
			totalPage = pService.pokeTotalPage(map1);
		}
		else if(count <=2) {
			list = pService.pokeTypeListData(map1);
			totalPage = pService.pokeTypeTotalPage(map1);
		}
		if (endPage > totalPage)
			endPage = totalPage;
		map2.put("list", list);
		map2.put("startPage", startPage);
		map2.put("endPage", endPage);
		map2.put("curPage", page);
		map2.put("totalPage", totalPage);
		map2.put("types", types);
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(map2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
