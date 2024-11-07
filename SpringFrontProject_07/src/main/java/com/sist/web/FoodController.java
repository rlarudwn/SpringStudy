package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	@GetMapping("food/login.do")
	public String foodLogin() {
		return "food/login";
	}
	@GetMapping("food/list.do")
	public String foodList() {
		return "food/list";
	}
	@GetMapping("food/detail.do")
	public String foodDetail(int fno, Model model) {
		model.addAttribute("fno", fno);
		return "food/detail";
	}
}
