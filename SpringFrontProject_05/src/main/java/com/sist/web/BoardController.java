package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board/list.do")
	public String boardList() {
		return "board/list";
	}
	@GetMapping("board/insert.do")
	public String boardInsert() {
		return "board/insert";
	}
	@GetMapping("board/detail.do")
	public String boardDetail(int no, Model model) {
		model.addAttribute("no", no);
		return "board/detail";
	}
	@GetMapping("board/update.do")
	public String boardUpdate(int no, Model model) {
		model.addAttribute("no", no);
		return "board/update";
	}
}
