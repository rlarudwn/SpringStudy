package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.sist.vo.*;

public interface BoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM vue_databoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT COUNT(*) FROM vue_databoard")
	public int boardTotalPage();
	
	@SelectKey(keyProperty = "no", resultType = int.class, before = true, statement="SELECT NVL(MAX(no)+1, 1) as no FROM vue_databoard")
	@Insert("INSERT INTO vue_databoard(no, name, subject, content, pwd, filename, filesize, filecount) "
			+ "VALUES(#{no}, #{name}, #{subject}, #{content}, #{pwd}, #{filename}, #{filesize}, #{filecount})")
	public void boardInsert(BoardVO vo);
	
	@Update("UPDATE vue_databoard SET hit=hit+1 WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday, hit, filename, filesize, filecount, content "
			+ "FROM vue_databoard WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	@Select("SELECT pwd FROM vue_databoard WHERE no=#{no}")
	public String boardGetPwd(int no);
	
	@Select("SELECT filename FROM vue_databoard WHERE no=#{no}")
	public String boardFileInfoData(int no);
	
	@Delete("DELETE FROM vue_databoard WHERE no=#{no}")
	public void boardDelete(int no);
	
	@Update("UPDATE vue_databoard SET name=#{name}, subject=#{subject}, content=#{content}, filename=#{filename}, filesize=#{filesize}, filecount=#{filecount} WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);

}
