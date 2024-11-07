package com.sist.main;


import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.PokeService;
import com.sist.vo.PokeVO;

@Controller
public class PokeController {
	@Autowired
	PokeService pService;
	@GetMapping("poke/list.do")
	public String pokeList(Model model) {
		model.addAttribute("main_jsp", "../poke/list2.jsp");
		return "main/main";
	}
	@GetMapping("poke/detail.do")
	public String pokeDetail(int no, Model model) {
		PokeVO vo=pService.pokeDetailData(no);
		model.addAttribute("detail", vo);
		model.addAttribute("main_jsp", "../poke/detail.jsp");
		return "main/main";
	}
}
