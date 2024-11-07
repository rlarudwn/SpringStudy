package com.sist.dao;

import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;

	public List<FoodVO> foodListData(Map map) {
		return mapper.foodListData(map);
	}

	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}

	public FoodVO foodDetail(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	
	public MemberVO memberLogin(String id, String pwd) {
		MemberVO vo=new MemberVO();
		int count=mapper.memberIdCheck(id);
		if(count==0) {
			vo.setMsg("NOID");
		}
		else {
			vo=mapper.memberInfoData(id);
			if(vo.getPwd().equals(pwd)) {
				vo.setMsg("OK");
			}
			else {
				vo.setMsg("NOPWD");
				vo.setSex("");
				vo.setName("");
				vo.setId("");
			}
		}
		return vo;
	}
}
