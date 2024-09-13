package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface EmpMapper {
	public List<EmpVO> empListData();
	@Results({
		@Result(property = "dvo.dname", column="dname"),
		@Result(property = "dvo.loc", column="loc"),
		@Result(property = "svo.grade", column="grade")
	})
	@Select("SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday, sal, dname, loc, grade "
			+ "FROM emp JOIN dept ON emp.deptno=dept.deptno "
			+ "JOIN salgrade ON sal BETWEEN losal AND hisal "
			+ "WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
}
