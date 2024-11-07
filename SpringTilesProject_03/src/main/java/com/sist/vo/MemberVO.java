package com.sist.vo;

import java.util.Date;

import lombok.Data;
@Data
public class MemberVO {
	private String id, pwd, name, sex, post, addr1, addr2, phone, email, content, birthday, dbday, admin, msg;
	private Date regdate;
}
