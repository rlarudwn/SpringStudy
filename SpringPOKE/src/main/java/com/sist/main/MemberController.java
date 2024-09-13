package com.sist.main;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.dao.MemberDAO;

@Controller
@RequestMapping("member/")
public class MemberController {
	@Autowired
	private MemberDAO dao;
	@GetMapping("login.do")
	public String memberLogin(Model model) {
		model.addAttribute("main_jsp", "../member/login.jsp");
		return "member/login";
	}
	
}
