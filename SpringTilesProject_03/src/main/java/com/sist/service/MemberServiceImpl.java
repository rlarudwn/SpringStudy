package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	@Override
	public MemberVO loginCheck(String id, String pwd) {
		MemberVO vo=new MemberVO();
		String msg="NOID";
		int count=dao.memberIdCheck(id);
		if(count==1) {
			MemberVO mvo=dao.memberLoginInfo(id);
			if(pwd.equals(mvo.getPwd())) {
				msg="OK";
				vo.setId(mvo.getId());
				vo.setAdmin(mvo.getAdmin());
				vo.setName(mvo.getName());
			}
			else {
				msg="NOPWD";
			}
		}
		vo.setMsg(msg);
		return vo;
	}

	
}
