package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

@Controller
@RequestMapping("recipe/")
public class RecipeController {
	@Autowired
	private RecipeService rService;
	@GetMapping("recipeList.do")
	public String recipeList(String page, Model model) {
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int start=(curPage-1)*12+1;
		int end=start+12-1;
		List<RecipeVO> list=rService.recipeListData(start, end);
		int count=rService.recipeTotalPage();
		int totalPage=(int)(Math.ceil(count/12.0));
		int startPage=(curPage-1)/10*10+1;
		int endPage=startPage+10-1;
		if(endPage>totalPage)
			endPage=totalPage;
		model.addAttribute("list", list);
		model.addAttribute("curPage", curPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		model.addAttribute("menu", "레시피 목록");
		return "recipe/recipeList";
	}
}
