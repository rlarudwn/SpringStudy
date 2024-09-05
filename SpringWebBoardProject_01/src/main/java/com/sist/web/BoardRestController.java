package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;

	@PostMapping(value = "board/updateOk.do", produces = "text/html;charset=UTF-8")
	public String boardUpdateOK(BoardVO vo) {
		String js = "";
		boolean bCheck = dao.boardUpdate(vo);
		if (bCheck) {
			js += "<script>" + "location.href='detail.do?no=" + vo.getNo() + "'" + "</script>";
		} else {
			js += "<script>" + "alert('비밀번호가 틀립니다')\n" + "history.back()" + "</script>";
		}
		return js;
	}

	@PostMapping(value = "board/deleteOk.do", produces = "text/html;charset=UTF-8")
	public String boardDeleteOk(BoardVO vo) {
		String js = "";
		boolean bCheck = dao.boardDelete(vo);
		if (bCheck) {
			js += "<script>" + "location.href='list.do'" + "</script>";
		} else {
			js += "<script>" + "alert('비밀번호가 틀립니다')\n" + "history.back()" + "</script>";
		}
		return js;
	}
}
