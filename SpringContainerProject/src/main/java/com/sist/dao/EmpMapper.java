package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmpMapper {
	@Select("SELECT empno, ename, job, hiredate, sal FROM emp")
	public List<EmpVO> empListData();
	//@Results	=> <resultMap>
}
