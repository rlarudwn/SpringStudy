package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.ReplyBoardVO;

import lombok.Delegate;

public interface ReplyBoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, group_tab, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, group_tab, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit, group_tab "
			+ "FROM spring_replyboard ORDER BY group_id ASC, no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ReplyBoardVO> replyboardListData(Map map);
	
	@Select("SELECT COUNT(*) FROM spring_replyboard")
	public int replyboardRowCount();
	
	@Insert("INSERT INTO spring_replyboard (no, name, subject, content, pwd, group_id) VALUES(srb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, (SELECT NVL(MAX(GROUP_id)+1, 1) FROM spring_replyboard))")
	public void replyboardInsert(ReplyBoardVO vo);
	
	@Select("SELECT no, subject, name, content, to_char(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday, hit, group_id, group_step, group_tab, root, dept, pwd "
			+ "FROM spring_replyboard WHERE no=#{no}")
	public ReplyBoardVO replyboardDetailData(int no);
	
	@Update("UPDATE spring_replyboard SET hit=hit+1 WHERE no=#{no}")
	public void replyboardHitIncrement(int no);
	
	@Select("SELECT pwd FROM spring_replyboard WHERE no=#{no}")
	public String replyboardGetPwd(int no);
	
	@Update("UPDATE spring_replyboard SET subject=#{subject}, name=#{name}, content=#{content} WHERE no=#{no}")
	public void replyboardUpdate(ReplyBoardVO vo);
	
	@Select("SELECT root, dept FROM spring_replyboard WHERE no=#{no}")
	public ReplyBoardVO replyboardRootData(int no);
	
	@Delete("DELETE FROM spring_replyboard WHERE no=#{no}")
	public void replyboardDelete(int no);
	
	@Update("UPDATE spring_replyboard SET subject='관리자가 삭제한 게시물입니다', content='관리자가 삭제한 게시물입니다' "
			+ "WHERE no=#{no}")
	public void replyboardSubjectUpdate(int no);
	
	@Update("UPDATE spring_replyboard SET dept=dept-1 WHERE no=#{no}")
	public void replyboardDepthDecrement(int no);
	
	@Select("SELECT group_id, group_step, group_tab FROM spring_replyboard WHERE no=#{no}")
	public ReplyBoardVO replyboardGroupData(int no);
	
	@Update("UPDATE spring_replyboard SET group_step=group_step+1 WHERE group_id=#{group_id} AND group_step>#{group_step}")
	public void replyboardGroupStepIncrement(ReplyBoardVO vo);
	
	@Insert("INSERT INTO spring_replyboard (no, name, subject, content, pwd, group_id, group_step, group_tab, root) "
			+ "VALUES (srb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, #{group_id}, #{group_step}, #{group_tab}, #{root})")
	public void replyboardReplyInsert(ReplyBoardVO vo);
	
	@Update("UPDATE spring_replyboard SET dept=dept+1 WHERE no=#{no}")
	public void boardDepthIncerement(int no);
	
}
