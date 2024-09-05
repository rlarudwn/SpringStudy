package com.sist.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.EmpVO;

public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empListData(){
		return getSqlSession().selectList("empListData");
	}
}
