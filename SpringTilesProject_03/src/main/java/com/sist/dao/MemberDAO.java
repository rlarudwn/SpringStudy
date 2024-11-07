/*
스프링 관리

dao						=>@Repository
Service				=>@Service
Manager				=>@Component
Controller		=>@Controller
Interceptor		=>xml:bean
AOP						=>@Component
 */
package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;

	public int memberIdCheck(String id) {
		return mapper.memberIdCheck(id);
	}

	public MemberVO memberLoginInfo(String id) {
		return mapper.memberLoginInfo(id);
	}
}
