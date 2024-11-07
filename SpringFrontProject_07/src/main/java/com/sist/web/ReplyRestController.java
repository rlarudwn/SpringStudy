package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;import lombok.val;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sist.dao.*;
@RestController
public class ReplyRestController {
	@Autowired
	private ReplyDAO dao;
	
	@GetMapping(value="reply/vueReplyList.do", produces = "text/plain;charset=UTF-8")
	public String replyVueReplyList(int fno) throws Exception{
		List<ReplyVO> list=dao.replyListData(fno);
		System.out.println(list.size());
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@PostMapping(value = "reply/vueReplyInsert.do", produces = "text/plain;charset=UTF-8")
	public void replyVueReplyInert(ReplyVO vo, HttpSession session) {
		vo.setName((String)session.getAttribute("name"));
		vo.setId((String)session.getAttribute("id"));
		dao.replyInsert(vo);
	}
	
	@GetMapping(value = "reply/vueReplyDelete.do", produces = "text/plain;charset=UTF-8")
	public void replyVueReplyDelete(int rno) {
		dao.replyDelete(rno);
	}
	@GetMapping(value = "reply/vueReplyUpdate.do", produces = "text/plain;charset=UTF-8")
	public void replyVueReplyUpdate(ReplyVO vo) {
		dao.replyUpdate(vo);
	}
	
}
