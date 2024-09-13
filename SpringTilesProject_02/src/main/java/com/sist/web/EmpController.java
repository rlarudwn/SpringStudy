package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
@RequestMapping("emp/")
public class EmpController {
	@Autowired
	EmpDAO dao;
	
	@GetMapping("list.do")
	public String empList(Model model) {
		List<EmpVO> list=dao.empListData();
		model.addAttribute("list", list);
		return "emp/list";
	}
	@GetMapping("detail.do")
	public String empDetail(int empno, Model model) {
		EmpVO vo=dao.empDetailData(empno);
		model.addAttribute("detail", vo);
		return "emp/detail";
	}
}
