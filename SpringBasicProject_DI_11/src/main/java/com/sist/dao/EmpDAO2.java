package com.sist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;
@Repository("dao2")
public class EmpDAO2 {
	private EmpMapper mapper;
	public void setMapper(EmpMapper mapper) {
		this.mapper=mapper;
	}
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}
