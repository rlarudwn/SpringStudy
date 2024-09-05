package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

public interface EmpMapper {
	@Select("SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday")
	public List<EmpVO> empListData();
}
