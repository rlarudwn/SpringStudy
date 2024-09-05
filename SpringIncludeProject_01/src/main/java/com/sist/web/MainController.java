package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.service.*;
import com.sist.vo.*;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("main/")
public class MainController {
	@Autowired
	private RecipeService rService; // DAO 동시 처리 => BT(관련된 기능 통합)

	@GetMapping("main.do")
	public String mainHome(String page, Model model, HttpServletRequest request) {
		if (page == null)
			page = "1";
		Cookie[] cookies = request.getCookies();
		List<RecipeVO> rList=new ArrayList<RecipeVO>();
		if (cookies != null) {
			for (int i=cookies.length-1;i>=0;i--) {
				if (cookies[i].getName().startsWith("recipe_")) {
					int no=Integer.parseInt(cookies[i].getValue());
					RecipeVO vo=rService.recipeCookieData(no);
					rList.add(vo);
				}
			}
		}
		int curPage = Integer.parseInt(page);
		Map map = new HashedMap();
		int start = (curPage - 1) * 20 + 1;
		int end = start + 20 - 1;
		map.put("start", start);
		map.put("end", end);
		int count = rService.recipeRowCount();
		int totalPage = (int) (Math.ceil(count / 20.0));
		List<RecipeVO> list = rService.recipeListData(map);
		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		model.addAttribute("rList", rList);
		model.addAttribute("size", rList.size());
		model.addAttribute("count", count);
		model.addAttribute("curPage", curPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
}
