package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sist.dao.*;
import java.util.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	@RequestMapping(value = "food/vueList.do", produces = "text/plain;charset=UTF-8")
	public String foodVueList(int page, String type) throws Exception{
		int start=(page-1)*20+1;
		int end=start+20-1;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("type", type);
		int totalPage=dao.foodTypeTotalPage(map);
		int startPage=(page-1)/10*10+1;
		int endPage=startPage+10-1;
		if(endPage>totalPage)
			endPage=totalPage;
		List<FoodVO> list=dao.foodTypeListData(map);
		map.put("list", list);
		map.put("curPage", page);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	
	@RequestMapping(value = "food/vueDetail.do", produces = "text/plain;charset=UTF-8")
	public String foodVueDetail(int fno) throws Exception{
		FoodVO vo=dao.foodDetailData(fno);
		String addr1=vo.getAddress();
		addr1=addr1.substring(addr1.indexOf(" ")+1);
		String addr2=addr1.trim();
		addr2=addr2.substring(addr2.indexOf(" ")+1);
		String addr3=addr2.trim();
		addr3=addr3.substring(0, addr3.indexOf(" "));
		System.out.println(addr3);
		List<FoodVO> near_list=dao.foodNearListData(addr3);
		Map map=new HashMap();
		map.put("vo", vo);
		map.put("address", vo.getAddress());
		map.put("near_list", near_list);
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
