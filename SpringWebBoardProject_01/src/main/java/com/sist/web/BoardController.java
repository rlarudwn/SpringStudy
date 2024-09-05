package com.sist.web;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	@GetMapping("board/list.do")
	public String boardList(String page, Model model){
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int start=(curPage-1)*10+1;
		int end=start+10-1;
		List<BoardVO> list=dao.boardListData(start, end);
		int count=dao.boardCount();
		int startPage=(curPage)/10*10+1;
		int endPage=startPage+10-1;
		int totalPage=(int)(Math.ceil(count/10.0));
		if(endPage>totalPage)
			endPage=totalPage;
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("count", count);
		return "board/list";
	}
	@GetMapping("board/insert.do")
	public String boardInsert() {
		return "board/insert";
	}
	@PostMapping("board/insertOk.do")
	public String boardInsertOk(BoardVO vo, Model model) {
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	@GetMapping("board/detail.do")
	public String boardDetail(int no, Model model) {
		BoardVO vo=dao.boardDetail(no);
		model.addAttribute("detail", vo);
		return "board/detail";
	}
	@GetMapping("board/update.do")
	public String boardUpdate(int no, Model model) {
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("detail", vo);
		return "board/update";
	}

	/*@PostMapping("board/updateOk.do")
	public String boardUpdateOk(BoardVO vo, Model model) {
		boolean bCheck=dao.boardUpdate(vo);
		model.addAttribute("bCheck", bCheck);
		model.addAttribute("no", vo.getNo());
		return "board/updateOk";
	}*/
	@PostMapping("board/updateOk2.do")
	@ResponseBody
	public String boardUpdateOk2(BoardVO vo, Model model) {
		String js="";
		boolean bCheck=dao.boardUpdate(vo);
		//model.addAttribute("bCheck", bCheck);
		//model.addAttribute("no", vo.getNo());
		if(bCheck) {
			js+="<script>"
					+ "location.href='detail.do?no="+vo.getNo()+"'"
					+ "</script>";
		}
		else {
			js+="<script>"
					+ "alert('password fail')\n"
					+ "history.back()"
					+ "</script>";
		}
		return js;
	}
	@GetMapping("board/delete.do")
	public String boardDelete(int no, Model model) {
		model.addAttribute("no", no);
		return "board/delete";
	}
	/*@PostMapping("board/deleteOk.do")
	@ResponseBody
	public String boardDeleteOk(BoardVO vo, Model model) {
		String js="";
		boolean bCheck=dao.boardDelete(vo);
		if(bCheck) {
			js+="<script>"
				+ "location.href='list.do'"
				+ "</script>";
		}
		else {
			js+="<script>"
					+ "alert('password fail')\n"
					+ "history.back()"
					+ "</script>";
		}
		return js;
	}*/
}
