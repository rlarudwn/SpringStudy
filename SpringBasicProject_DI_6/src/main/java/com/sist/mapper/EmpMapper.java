package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

public interface EmpMapper {
	@Select("SELECT empno, ename, job, hiredate, sal FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
}
