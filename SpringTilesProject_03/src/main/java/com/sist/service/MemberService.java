package com.sist.service;

import com.sist.vo.MemberVO;

public interface MemberService {
	public MemberVO loginCheck(String id, String pwd);
}
