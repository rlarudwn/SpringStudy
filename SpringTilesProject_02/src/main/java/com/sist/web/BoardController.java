package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board/")
public class BoardController {
	@GetMapping("list.do")
	public String boardList() {
		return "board/list";
	}
}
