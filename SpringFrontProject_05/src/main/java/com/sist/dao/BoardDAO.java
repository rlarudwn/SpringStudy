package com.sist.dao;
import com.sist.vo.*;
import com.sist.mapper.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(Map map){
		return mapper.boardListData(map);
	}
	public int boardTotalPage(){
		return mapper.boardTotalPage();
	}
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardDetail(int no) {
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
	public String boardFileInfoData(int no) {
		return mapper.boardFileInfoData(no);
	}
	
	public String boardDelete(int no, String pwd) {
		String result="NO";
		String tmp=mapper.boardGetPwd(no);
		if(tmp.equals(pwd)) {
			result="OK";
			mapper.boardDelete(no);
		}
		return result;
	}
	
	public BoardVO boardDetailData(int no) {
		return mapper.boardDetailData(no);
	}
	
	public String boardUpdate(BoardVO vo) {
		String result="NO";
		String tmp=mapper.boardGetPwd(vo.getNo());
		if(tmp.equals(vo.getPwd())) {
			result="OK";
			mapper.boardUpdate(vo);
		}
		return result;
	}
}
