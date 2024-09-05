package com.sist.main;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.PokeDAO;
import com.sist.vo.PokeVO;

@Controller
@RequestMapping("poke/")
public class PokeController {
	@Autowired
	PokeDAO dao;
	@GetMapping("list.do")
	public String pokeList(String page, String ss, Model model) {
		if(page==null)
			page="1";
		if(ss==null)
			ss="";
		int curPage=Integer.parseInt(page);
		int start=(curPage-1)*12+1;
		int end=start+12-1;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("ss", ss);
		List<PokeVO> list=dao.pokeListData(map);
		int startPage=(curPage-1)/10*10+1;
		int endPage=startPage+10-1;
		int totalPage=dao.pokeTotalPage(map);
		if(endPage>totalPage)
			endPage=totalPage;
		model.addAttribute("list", list);
		model.addAttribute("curPage", curPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("main_jsp", "../poke/list.jsp");
		return "main/main";
	}
	@GetMapping("detail.do")
	public String pokeDetail(int no, Model model) {
		PokeVO vo=dao.pokeDetailData(no);
		model.addAttribute("detail", vo);
		model.addAttribute("main_jsp", "../poke/detail.jsp");
		return "main/main";
	}
}
