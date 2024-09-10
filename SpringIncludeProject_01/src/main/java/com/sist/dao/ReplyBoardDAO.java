package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	public String replyboardUpdate(ReplyBoardVO vo) {
		String result="NO";
		String temp=mapper.replyboardGetPwd(vo.getNo());
		System.out.println(temp);
		if(vo.getPwd().equals(temp)) {
			result="OK";
			mapper.replyboardUpdate(vo);
		}
		return result;
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void replyboardReplyInsert(int pno, ReplyBoardVO vo) {
		ReplyBoardVO pvo=mapper.replyboardGroupData(pno);
		mapper.replyboardGroupStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		mapper.replyboardReplyInsert(vo);
		mapper.boardDepthIncerement(pno);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String replyboardDelete(int no, String pwd) {
		String result="NO";
		String pwd_temp=mapper.replyboardGetPwd(no);
		if(pwd.equals(pwd_temp)) {
			result="OK";
			ReplyBoardVO rvo=mapper.replyboardRootData(no);
			if(rvo.getDept()==0) {
				mapper.replyboardDelete(no);
			}
			else {
				mapper.replyboardSubjectUpdate(no);
			}
			mapper.replyboardDepthDecrement(rvo.getRoot());
		}
		return result;
	}
}
