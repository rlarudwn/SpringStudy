package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/")
public class AdminController {
	@GetMapping("adminMain.do")
	public String adminMain() {
		return "admin";
	}
	@GetMapping("adminMember.do")
	public String adminMember() {
		return "admin/adminMember";
	}
}
