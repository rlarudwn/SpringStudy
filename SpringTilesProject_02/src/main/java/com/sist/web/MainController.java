package com.sist.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Controller
public class MainController {
	@Autowired
	RecipeDAO dao;
	@GetMapping("main/main.do")
	public String mainHome(String page, Model model) {
		if (page == null)
			page = "1";
		int curPage = Integer.parseInt(page);
		Map map = new HashedMap();
		int start = (curPage - 1) * 20 + 1;
		int end = start + 20 - 1;
		map.put("start", start);
		map.put("end", end);
		int count = dao.recipeRowCount();
		int totalPage = (int) (Math.ceil(count / 20.0));
		List<RecipeVO> list = dao.recipeListData(map);
		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		model.addAttribute("count", count);
		model.addAttribute("curPage", curPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		return "main";
	}
}
