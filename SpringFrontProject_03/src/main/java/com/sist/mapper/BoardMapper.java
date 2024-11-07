package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;
import com.sist.vo.*;

public interface BoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM vue_board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT COUNT(*) FROM vue_board")
	public int boardTotalPage();
	
	@Insert("INSERT INTO vue_board(no, name, subject, content, pwd) "
			+ "VALUES(vb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd})")
	public void boardInsert(BoardVO vo);
	
	@Update("UPDATE vue_board SET hit=hit+1 WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no, subject, name, content, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday, hit "
			+ "FROM vue_board WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	@Select("SELECT pwd FROM vue_board WHERE no=#{no}")
	public String boardGetPwd(int no);
	
	@Delete("DELETE FROM vue_board WHERE no=#{no}")
	public void boardDelete(int no);
	
	@Update("UPDATE vue_board SET name=#{name}, subject=#{subject}, content=#{content} WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
}


