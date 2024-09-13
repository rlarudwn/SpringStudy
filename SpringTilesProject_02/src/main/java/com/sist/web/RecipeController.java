package com.sist.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
@RequestMapping("recipe/")
public class RecipeController {
	@Autowired
	RecipeDAO dao;

	@GetMapping("detail.do")
	public String recipeDetail(int no, Model model) {
		RecipeDetailVO vo = dao.recipeDetail(no);
		String data = vo.getData();
		data = data.replace("±¸¸Å", "");
		vo.setData(data.trim());
		String[] makes = vo.getFoodmake().split("\n");
		List<String> iList=new ArrayList<String>();
		List<String> mList=new ArrayList<String>();
		for (String s : makes) {
			StringTokenizer st = new StringTokenizer(s, "^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		model.addAttribute("mList", mList);
		model.addAttribute("iList", iList);
		model.addAttribute("detail", vo);
		return "recipe/detail";
	}
	@RequestMapping("find.do")
	public String recipeFind(String fd, String page, Model model) {
		if (page == null)
			page = "1";
		if(fd==null)
			fd="";
		int curPage = Integer.parseInt(page);
		Map map = new HashedMap();
		int start = (curPage - 1) * 20 + 1;
		int end = start + 20 - 1;
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		int count = dao.recipeFindRowCount(map);
		int totalPage = (int) (Math.ceil(count / 20.0));
		List<RecipeVO> list = dao.recipeFindListData(map);
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
		model.addAttribute("fd", fd);
		return "recipe/find";
	}
	@GetMapping("chefList.do")
	public String chefList(String page, Model model) {
		if (page == null)
			page = "1";
		int curPage = Integer.parseInt(page);
		Map map = new HashedMap();
		int start = (curPage - 1) * 50 + 1;
		int end = start + 50 - 1;
		map.put("start", start);
		map.put("end", end);
		int count = dao.chefRowCount();
		int totalPage = (int) (Math.ceil(count / 50.0));
		List<ChefVO> list = dao.chefListData(map);
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
		return "recipe/chefList";
	}
	@GetMapping("chefRecipe.do")
	public String chefRecipe(String chef, String page, Model model) {
		if (page == null)
			page = "1";
		int curPage = Integer.parseInt(page);
		Map map = new HashedMap();
		int start = (curPage - 1) * 20 + 1;
		int end = start + 20 - 1;
		map.put("start", start);
		map.put("end", end);
		map.put("chef", chef);
		int count = dao.chefRecipeRowCount(map);
		int totalPage = (int) (Math.ceil(count / 20.0));
		List<RecipeVO> list = dao.chefRecipeListData(map);
		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		model.addAttribute("chef", chef);
		model.addAttribute("count", count);
		model.addAttribute("curPage", curPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		return "recipe/chefRecipe";
	}
}
