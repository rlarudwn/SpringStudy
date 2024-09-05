package com.sist.dao;

import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private DataBoardMapper mapper;
	public List<DataBoardVO> databoardListData(int start, int end){
		return mapper.databoardListData(start, end);
	}
	
	public int databoardCount() {
		return mapper.databoardCount();
	}
	
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	public DataBoardVO databoardDetail(int no) {
		mapper.databoardHitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	public boolean databoardDelete(int no, String pwd) {
		boolean bCheck=false;
		String pwd_temp=mapper.databoardPwd(no);
		if(encoder.matches(pwd, pwd_temp)) {
			mapper.databoardDelete(no);
			bCheck=true;
		}
		return bCheck;
	}
	public DataBoardVO databoardFileInfo(int no) {
		return mapper.databoardFileInfo(no);
	}
}
