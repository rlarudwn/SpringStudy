package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.ReplyBoardDAO;
import com.sist.vo.ReplyBoardVO;

@Service
public class ReplyBoardServiceImpl implements ReplyBoardService{
	@Autowired
	ReplyBoardDAO dao;

	@Override
	public List<ReplyBoardVO> replyboardListData(Map map) {
		return dao.replyboardListData(map);
	}

	@Override
	public void replyboardInsert(ReplyBoardVO vo) {
		dao.replyboardInsert(vo);
	}

	@Override
	public int replyboardRowCount() {
		return dao.replyboardRowCount();
	}

	@Override
	public ReplyBoardVO replyboardDetail(int no) {
		return dao.replyboardDetail(no);
	}

	@Override
	public ReplyBoardVO replyboardDetailData(int no) {
		return dao.replyboardDetailData(no);
	}
}
