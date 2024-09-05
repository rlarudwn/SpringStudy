package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

// Model	=> 사용자 요청 처리
@Controller
@RequestMapping("food/")
public class FoodController {
	@Autowired
	private FoodDAO dao;
	@GetMapping("list.do")
	public String food_list(String page, Model model) {
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int rowSize=20;
		int start=(curPage-1)*rowSize+1;
		int end=start+rowSize-1;
		List<FoodVO> list=dao.foodListData(start, end);
		int totalPage=dao.foodTotalPage();
		final int BLOCK=10;
		int startPage=(curPage-1)/BLOCK*BLOCK+1;
		int endPage=startPage+BLOCK-1;
		if(endPage>totalPage)
			endPage=totalPage;
		model.addAttribute("curPage", curPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		return "food/list";
	}
	@GetMapping("insert.do")
	public String insert(Model model) {
		return "food/insert";
	}
	@GetMapping("insertOk.do")
	public String foodInsert(MemberVO vo, Model model) {
		model.addAttribute("vo", vo);
		return "food/detail";
	}
}
