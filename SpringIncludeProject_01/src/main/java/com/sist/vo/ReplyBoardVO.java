package com.sist.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ReplyBoardVO {
	private int no, hit, group_id, group_step, group_tab, root, dept;
	private String name, subject, content, pwd, dbday;
	private Date regdate;
}
