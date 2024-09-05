package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

public interface EmpMapper {
	@Results({
		@Result(property = "dvo.dname", column = "dname"),
		@Result(property = "dvo.loc", column = "loc"),
		@Result(property = "svo.grade", column = "grade")
	})
	@Select("SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday, "
			+ "dept.dname, salgrade.grade "
			+ "FROM emp, dept, salgrade "
			+ "WHERE emp.deptno=dept.deptno "
			+ "AND sal BETWEEN losal AND hisal")
	public List<EmpVO> empListData();
}
