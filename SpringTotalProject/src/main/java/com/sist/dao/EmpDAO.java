package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
	
	public EmpVO empDetailData(int empno) {
		return mapper.empDetailData(empno);
	}
	
	public List<String> empEnameList(){
		return mapper.empEnameList();
	}
	
	public List<EmpVO> empFindList(String[] names){
		return mapper.empFindList2(names);
	}
	
	public List<EmpVO> empFindListData(String[] names){
		return mapper.empFindListData(names);
	}
	
	public List<EmpVO> empFindOption(Map map){
		return mapper.empFindOption(map);
	}
}
