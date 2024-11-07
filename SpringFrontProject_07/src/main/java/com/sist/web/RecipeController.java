package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
	@GetMapping("recipe/list.do")
	public String recipeList() {
		return "recipe/list";
	}
	@GetMapping("recipe/detail.do")
	public String recipeDetail(int no, Model model, HttpSession session) {
		String id=(String)session.getAttribute("id");
		model.addAttribute("no", no);
		model.addAttribute("sessionId", id);
		return "recipe/detail";
	}
}
