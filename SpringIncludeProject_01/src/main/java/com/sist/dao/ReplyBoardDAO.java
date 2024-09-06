package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.ReplyBoardMapper;
import com.sist.vo.ReplyBoardVO;
@Repository
public class ReplyBoardDAO {
	@Autowired
	ReplyBoardMapper mapper;
	public List<ReplyBoardVO> replyboardListData(Map map){
		return mapper.replyboardListData(map);
	}
	public void replyboardInsert(ReplyBoardVO vo) {
		mapper.replyboardInsert(vo);
	}
	
	public int replyboardRowCount() {
		return mapper.replyboardRowCount();
	}
	
	public ReplyBoardVO replyboardDetail(int no){
		mapper.replyboardHitIncrement(no);
		return mapper.replyboardDetailData(no);
	}
	
	public ReplyBoardVO replyboardDetailData(int no) {
		return mapper.replyboardDetailData(no);
	}
}
