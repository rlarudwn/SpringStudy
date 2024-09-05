/*

DAO : DB����
Service : DAO������ ����, ���ռ��� ���� ���α׷�
Manager : Open API
Contrller : Model
RestController : JavaScript, kotlin, flutter
ControllerAdvice : ���� ����ó��
VO : ����� ��������
Mapper : ������ �� ����

������̼�

class�� : type
�޼ҵ��� : method
��������� : field
�Ű����� �� : param
������ ��
 */

package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class BoardDAO {
	@Autowired
	BoardMapper mapper;
	public List<BoardVO> boardListData(int start, int end){
		return mapper.boardListData(start, end);
	}
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	public int boardCount() {
		return mapper.boardCount();
	}
	public BoardVO boardDetail(int no) {
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	public BoardVO boardDetailData(int no) {
		return mapper.boardDetailData(no);
	}
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck=false;
		String pwd=mapper.boardPwd(vo.getNo());
		if(pwd.equals(vo.getPwd())) {
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}
	public boolean boardDelete(BoardVO vo) {
		boolean bCheck=false;
		String pwd=mapper.boardPwd(vo.getNo());
		if(pwd.equals(vo.getPwd())) {
			bCheck=true;
			mapper.boardDelete(vo.getNo());
		}
		return bCheck;
	}
}
