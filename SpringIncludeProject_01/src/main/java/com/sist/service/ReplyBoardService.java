package com.sist.service;

import java.util.*;

import com.sist.vo.ReplyBoardVO;

public interface ReplyBoardService {
	public List<ReplyBoardVO> replyboardListData(Map map);
	public void replyboardInsert(ReplyBoardVO vo);
	public int replyboardRowCount();
	public ReplyBoardVO replyboardDetail(int no);
	public ReplyBoardVO replyboardDetailData(int no);
	public String replyboardUpdate(ReplyBoardVO vo);
	public void replyboardReplyInsert(int pno, ReplyBoardVO vo);
	public String replyboardDelete(int no, String pwd);
}
