package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM project_member "
			+ "WHERE id=#{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT pwd, id, name, admin FROM project_member "
			+ "WHERE id=#{id}")
	public MemberVO memberLoginInfo(String id);
}
