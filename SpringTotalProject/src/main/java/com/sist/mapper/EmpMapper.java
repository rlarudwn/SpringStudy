package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface EmpMapper {
	@Select("SELECT empno, ename, deptno, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp ORDER BY empno")
	public List<EmpVO> empListData();
	
	@Select("SELECT empno, ename, deptno, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp ORDER BY empno WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
	
	@Select("SELECT DISTINCT ename FROM emp")
	public List<String> empEnameList();
		
	@Select("<script>"
			+ "SELECT empno, ename, deptno, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp "
			+ "<trim prefix=\"WHERE ename IN(\" suffix=\")\" suffixOverrides=\")\" "
			+ "preifxOverrides=\"(\"> "
			+ "<foreach collection=\"names\" item=\"name\" open=\"(\" close=\")\" separator=\",\"> "
			+ "#{name} "
			+ "</foreach>"
			+ "</trim>"
			+ "</script>")
	public List<EmpVO> empFindList(@Param("names") String[] names);
	@Select("<script>"
			+ "SELECT empno, ename, deptno, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp "
			+ "<trim prefix='WHERE ename IN(' suffix=')' suffixOverrides=')' "
			+ "prefixOverrides='('> "
			+ "<foreach collection='names' item='name' open='(' close=')' separator=','> "
			+ "#{name} "
			+ "</foreach>"
			+ "</trim>"
			+ "</script>")
	public List<EmpVO> empFindList2(@Param("names")String[] names);
	
	public List<EmpVO> empFindListData(String[] names);
	public List<EmpVO> empFindOption(Map map);
}
