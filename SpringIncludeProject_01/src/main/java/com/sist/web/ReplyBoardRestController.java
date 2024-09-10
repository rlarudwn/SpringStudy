package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.ReplyBoardService;
import com.sist.vo.ReplyBoardVO;
@RestController
public class ReplyBoardRestController {
	@Autowired
	private ReplyBoardService rbService;
	@PostMapping("replyboard/updateOk.do")
	public String replyboardUpdateOk(int pno, ReplyBoardVO vo) {
		String result=rbService.replyboardUpdate(vo);
		return result;
	}
	
	@PostMapping("replyboard/deleteOk.do")
	public String replyboardDeleteOk(int no, String pwd) {
		String result=rbService.replyboardDelete(no, pwd);
		return result;
	}

}
