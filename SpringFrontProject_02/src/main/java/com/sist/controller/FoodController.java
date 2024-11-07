package com.sist.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
@RequestMapping("food/")
public class FoodController {
	@Autowired
	private FoodDAO dao;

	@GetMapping("list.do")
	public String foodList(String page, Model model) {
		if (page == null)
			page = "1";
		Map map = new HashMap();
		int curPage = Integer.parseInt(page);
		int start = (curPage - 1) * 12 + 1;
		int end = start + 12 - 1;
		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		int totalPage = dao.foodTotalPage();
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list = dao.foodListData(map);
		if (endPage > totalPage)
			endPage = totalPage;

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("list", list);
		return "food/list";
	}
	@GetMapping("list2.do")
	public String foodList2() {
		return "food/list2";
	}
	@GetMapping("find.do")
	public String foodFind(String address, String page, Model model) {
		if (page == null)
			page = "1";
		if(address==null)
			address="";
		Map map = new HashMap();
		int curPage = Integer.parseInt(page);
		int start = (curPage - 1) * 12 + 1;
		int end = start + 12 - 1;
		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		map.put("start", start);
		map.put("end", end);
		map.put("address", address);
		int totalPage = dao.foodFindTotalPage(map);
		List<FoodVO> list = dao.foodFindListData(map);
		if (endPage > totalPage)
			endPage = totalPage;

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("list", list);
		model.addAttribute("address", address);
		return "food/find";
	}
	@GetMapping("find2.do")
	public String foodFind2() {
		return "food/find2";
	}
}
