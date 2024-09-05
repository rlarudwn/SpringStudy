package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.*;
import com.sist.vo.*;

public interface BoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM spring_board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start")int start, @Param("end")int end);
	
	@Insert("INSERT INTO spring_board(no, name, subject, content, pwd) "
			+ "VALUES(sb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd})")
	public void boardInsert(BoardVO vo);
	
	@Select("SELECT COUNT(*) FROM spring_board")
	public int boardCount();
	
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, content "
			+ "FROM spring_board WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	@Update("UPDATE spring_board SET hit=hit+1 WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Update("UPDATE spring_board SET name=#{name}, subject=#{subject}, content=#{content}")
	public void boardUpdate(BoardVO vo);
	
	@Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	public String boardPwd(int no);
	
	@Delete("DELETE FROM spring_board WHERE no=#{no}")
	public void boardDelete(int no);
}
