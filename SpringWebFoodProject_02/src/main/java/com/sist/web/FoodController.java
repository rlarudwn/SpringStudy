package com.sist.web;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/list.do")
	public String foodList(String page, Model model) {
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int start=(curPage-1)*20+1;
		int end=start +20-1;
		int totalPage=dao.foodTotalPage();
		int startPage=(curPage-1)/10*10+1;
		int endPage=startPage+10-1;
		if(endPage>totalPage)
			endPage=totalPage;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=dao.foodListData(map);
		
		model. addAttribute("list", list);
		model. addAttribute("curPage", curPage);
		model. addAttribute("startPage", startPage);
		model. addAttribute("endPage", endPage);
		model. addAttribute("totalPage", totalPage);
		return "food/list";
	}
	@GetMapping("food/detail.do")
	public String foodDetail(int fno, Model model) {
		FoodVO vo=dao.foodDetailData(fno);
		return "food/detail";
	}
}
