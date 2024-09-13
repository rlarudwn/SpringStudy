package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
@Repository
public class MemberDAO {
	@Autowired
	MemberMapper mapper;
	
	public String memberLogin(String id, String pwd) {
		String result="NO";
		int count=mapper.memberIdChek(id);
		if(count>0) {
			String temp=mapper.memberPwdCheck(id);
			if(pwd.equals(temp)) {
				result="OK";
			}
		}
		return result;
	}
}
