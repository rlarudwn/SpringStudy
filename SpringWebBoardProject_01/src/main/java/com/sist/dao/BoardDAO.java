/*

DAO : DB연동
Service : DAO여러개 통합, 결합성이 낮은 프로그램
Manager : Open API
Contrller : Model
RestController : JavaScript, kotlin, flutter
ControllerAdvice : 통합 예외처리
VO : 사용자 데이터형
Mapper : 관리할 수 없다

어노테이션

class위 : type
메소드위 : method
멤버변수위 : field
매개변수 옆 : param
생성자 위
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
