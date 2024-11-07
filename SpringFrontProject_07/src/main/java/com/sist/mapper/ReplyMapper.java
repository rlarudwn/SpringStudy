package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface ReplyMapper {
	@Select("SELECT rno, fno, id, name, msg, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday FROM spring_reply WHERE fno=#{fno} ORDER BY rno DESC")
	public List<ReplyVO> replyListData(int fno);
	
	@Insert("INSERT INTO spring_reply values((SELECT MAX(rno)+1 FROM spring_reply), #{fno}, #{id}, #{name}, #{msg}, sysdate)")
	public void replyInsert(ReplyVO vo);
	
	@Delete("DELETE FROM spring_reply WHERE rno=#{rno}")
	public void replyDelete(int rno);
	
	@Update("UPDATE spring_reply SET msg=#{msg} WHERE rno=#{rno}")
	public void replyUpdate(ReplyVO vo);
}
