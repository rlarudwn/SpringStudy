package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import com.sist.service.*;
import com.sist.vo.MemberVO;

@RestController
@CrossOrigin(origins = "*")
public class MemberRestController {
	@Autowired
	MemberService mService;
	@Async
	@PostMapping(value = "member/loginOk.do", produces = "text/html;charset=UTF-8")
	public String memberLoginOk(String id, String pwd, HttpSession session) {
		String script="";
		MemberVO vo=mService.loginCheck(id, pwd);
		if(vo.getMsg().equals("NOID")) {
			script="<script type=\"text/javascript\">"
					+ "alert('아이디가 존재하지 않습니다')\n"
					+ "history.back()"
					+ "</script>";
		}
		else if(vo.getMsg().equals("NOPWD")) {
			script="<script type=\"text/javascript\">"
					+ "alert('비밀번호가 틀렸습니다')\n"
					+ "history.back()"
					+ "</script>";
			
		}
		else {
			session.setAttribute("name", vo.getName());
			session.setAttribute("id", vo.getId());
			session.setAttribute("admin", vo.getAdmin());
			script="<script>"
					+ "location.href='../main/main.do'"
					+ "</script>";
			
		}
		return script;
	}
}
