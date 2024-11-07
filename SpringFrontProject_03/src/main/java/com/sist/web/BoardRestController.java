package com.sist.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value = "board/vueList.do", produces = "text/plain;charset=UTF-8")
	public String boardVueList(int page) throws Exception{
		int rowSize=10;
		int start=(page-1)*rowSize+1;
		int end=start+rowSize-1;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		int count=dao.boardTotalPage();
		int totalPage=(int)(Math.ceil(count/10.0));
		count=count-(page-1)*rowSize;
		map.put("today", new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
		map.put("totalPage", totalPage);
		map.put("curPage", page);
		map.put("list", list);
		map.put("count", count);
		
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	
	@PostMapping(value = "board/vueInsert.do",produces = "text/plain;charset=UTF-8")
	public String boardVueInsert(BoardVO vo) {
		System.out.println(vo);
		String result="";
		try {
			result="OK";
			dao.boardInsert(vo);
		} catch (Exception e) {
			result="NO";
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value = "board/vueDetail.do", produces = "text/plain;charset=UTF-8")
	public String boardVueDetail(int no) throws Exception{
		BoardVO vo=dao.boardDetail(no);
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	
	@GetMapping(value = "board/vueDelete.do", produces = "text/plain;charset=UTF-8")
	public String boardVueDelete(int no, String pwd){
		String result=dao.boardDelete(no, pwd);
		return result;
	}
	
	@GetMapping(value = "board/vueDetailData.do", produces = "text/plain;charset=UTF-8")
	public String boardVueDetailData(int no) throws Exception{
		BoardVO vo=dao.boardDetailData(no);
		JsonMapper mapper=new JsonMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	
	@PostMapping(value = "board/vueUpdate.do", produces = "text/plain;charset=UTF-8")
	public String boardVueUpdate(BoardVO vo) {
		String result=dao.boardUpdate(vo);
		return result;
	}
}
