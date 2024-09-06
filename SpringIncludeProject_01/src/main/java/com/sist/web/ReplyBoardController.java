package com.sist.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.commons.CommonsPage;
import com.sist.service.ReplyBoardService;
import com.sist.vo.RecipeVO;
import com.sist.vo.ReplyBoardVO;

@Controller
@RequestMapping("replyboard/")
public class ReplyBoardController {
	ReplyBoardService rbService;
	@Autowired
	public ReplyBoardController(ReplyBoardService rbService) {
		this.rbService=rbService;
	}
	@GetMapping("list.do")
	public String replyboardList(String page, Model model) {
		Map map=CommonsPage.pageConfig(page, 10);
		int curPage=(Integer) map.get("curPage");
		int startPage = ( - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		List<ReplyBoardVO> list=rbService.replyboardListData(map);
		int count=rbService.replyboardRowCount();
		int totalPage=(int)(Math.ceil(count/10.0));
		if(endPage>totalPage)
			endPage=totalPage;
		count=count-(curPage-1)*10;
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../replyboard/list.jsp");
		model.addAttribute("today", new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
		return "main/main";
	}
	@GetMapping("insert.do")
	public String replyboardInsert(Model model) {
		model.addAttribute("main_jsp", "../replyboard/insert.jsp");
		return "main/main";
	}
	@PostMapping("insertOk.do")
	public String replyboardInsertOk(ReplyBoardVO vo) {
		rbService.replyboardInsert(vo);
		return "redirect:../replyboard/list.do";
	}
	@GetMapping("detail.do")
	public String replyboardDetail(int no, Model model) {
		ReplyBoardVO vo=rbService.replyboardDetail(no);
		model.addAttribute("detail", vo);
		model.addAttribute("main_jsp", "../replyboard/detail.jsp");
		return "main/main";
	}
}
