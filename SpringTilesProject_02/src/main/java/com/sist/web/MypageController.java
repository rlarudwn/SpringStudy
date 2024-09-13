package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage/")
public class MypageController {
	@GetMapping("mypageMain.do")
	public String mypageMain() {
		return "mypage";
	}
	@GetMapping("mypageJjim.do")
	public String mypageJjim() {
		return "mypage/mypageJjim";
	}
	@GetMapping("mypageJoin.do")
	public String mypageJoin() {
		return "mypage/mypageJoin";
	}
}
