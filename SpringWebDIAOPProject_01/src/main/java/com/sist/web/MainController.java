package com.sist.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String mainPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "hello spring mvc");
		return "main/main";
	}
}
