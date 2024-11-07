package com.sist.dao;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	//	�Խ��� ��� ���
	public List<BoardVO> boardListData(Map map){
		return mapper.boardListData(map);
	}
	
	//	�Խñ� ���� ���
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardDetail(int no) {
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
	public String boardDelete(int no, String pwd) {
		String tmp=mapper.boardGetPwd(no);
		String result="NO";
		if(tmp.equals(pwd)) {
			mapper.boardDelete(no);
			result="OK";
		}
		return result;
	}
	public BoardVO boardDetailData(int no) {
		return mapper.boardDetailData(no);
	}
	
	public String boardUpdate(BoardVO vo) {
		String result="";
		String tmp=mapper.boardGetPwd(vo.getNo());
		if(tmp.equals(vo.getPwd())) {
			mapper.boardUpdate(vo);
			result="OK";
		}
		return result;
	}
}
