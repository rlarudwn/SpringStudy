package com.sist.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.mapper.*;
import com.sist.vo.*;
public interface DataBoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM spring_databoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(@Param("start")int start, @Param("end")int end);
	
	@Select("SELECT COUNT(*) FROM spring_databoard")
	public int databoardCount();
	
	@Insert("INSERT INTO spring_databoard(no, name, subject, content, pwd,"
			+ "filename, filesize, filecount)"
			+ "VALUES(sdb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, #{filename}, #{filesize}, #{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	@Select("SELECT no, name, subject, content, to_char(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday, "
			+ "hit, filename, filesize, filecount "
			+ "FROM spring_databoard "
			+ "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	
	@Update("UPDATE spring_databoard SET hit=hit+1 WHERE no=#{no}")
	public void databoardHitIncrement(int no);
	
	@Select("SELECT pwd FROM spring_databoard WHERE no=#{no}")
	public String databoardPwd(int no);
	
	@Delete("DELETE FROM spring_databoard WHERE no=#{no}")
	public void databoardDelete(int no);
	
	@Select("SELECT filename, filecount FROM spring_databoard WHERE no=#{no}")
	public DataBoardVO databoardFileInfo(int no);
}
