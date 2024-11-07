package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("food/list.do")
	public String foodList(String page, String type, Model model) {
		if(page==null)
			page="1";
		if(type==null)
			type="";
		int curPage=Integer.parseInt(page);
		model.addAttribute("type", type);
		model.addAttribute("page", curPage);
		return "food/list";
	}
	@RequestMapping("food/detail.do")
	public String foodDetail(int fno, int page, String type, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("page", page);
		model.addAttribute("fno", fno);
		return "food/detail";
	}
}
