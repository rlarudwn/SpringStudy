package com.sist.dao;

import java.util.List;

import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;

public class EmpDAO {
	private EmpMapper mapper;
	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}