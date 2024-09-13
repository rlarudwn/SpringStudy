package com.sist.main;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.MemberDAO;
@RestController
public class MemberRestController {
	@Autowired
	private MemberDAO dao;
	@GetMapping(value = "member/loginCheck.do", produces = "text/plain;charset=UTF-8")
	public String memberLoginCheck(String id, String pwd, Model model) {
		System.out.println(id);
		System.out.println(pwd);
		String json="";
		String result=dao.memberLogin(id, pwd);
		Map map=new HashedMap();
		map.put("result", result);
		ObjectMapper mapper=new ObjectMapper();
		try {
			json=mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
