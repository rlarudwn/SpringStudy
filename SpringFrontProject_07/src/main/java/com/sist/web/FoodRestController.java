package com.sist.web;
import java.util.*;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sist.dao.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	@PostMapping(value = "food/vueLogin.do", produces = "text/plain;charset=UTF-8")
	public String foodVueLogin(String id, String pwd, HttpSession session) {
		MemberVO vo=dao.memberLogin(id, pwd);
		if(vo.getMsg()=="OK") {
			session.setAttribute("name", vo.getName());
			session.setAttribute("id", id);
			session.setAttribute("sex", vo.getSex());
		}
		return vo.getMsg();
	}
	
	@GetMapping(value = "food/vueList.do", produces = "text/plain;charset=UTF-8")
	public String foodVueList(int page) throws Exception{
		Map map=new HashMap();
		int start=(page-1)*12+1;
		int end=start+12-1;
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=dao.foodListData(map);
		final int BLCOK=7;
		int totalPage=dao.foodTotalPage();
		int startPage=(page-1)/BLCOK*BLCOK+1;
		int endPage=startPage+BLCOK-1;
		if(endPage>totalPage)
			endPage=totalPage;
		for(FoodVO vo:list) {
			vo.setPoster("http://www.menupan.com"+vo.getPoster());
		}
		map.put("list", list);
		map.put("totalPage", totalPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("curPage", page);
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	
	@GetMapping(value = "food/vueDetail.do", produces = "text/plain;charset=UTF-8")
	public String foodVueDetail(int fno) throws Exception{
		FoodVO vo=dao.foodDetail(fno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
}
