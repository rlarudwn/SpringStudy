package com.sist.web;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

@Controller
public class EmpController {
	@Autowired
	private EmpDAO dao;
	@GetMapping("emp/list.do")
	public String empList(Model model) {
		List<EmpVO> list=dao.empListData();
		model.addAttribute("list", list);
		return "emp/list";
	}
	@RequestMapping("emp/find.do")
	public String empFind(Model model) {
		List<String> list=dao.empEnameList();
		model.addAttribute("list", list);
		model.addAttribute("size", list.size());
		return "emp/find";
	}
	@PostMapping("emp/findOk.do")
	public String empFindOk(String[] names, Model model) {
		List<EmpVO> list=dao.empFindListData(names);
		model.addAttribute("list", list);
		return "emp/findOk";
	}
	@RequestMapping("emp/find2.do")
	public String empFindSecond(String fd, String ss, Model model) {
		if(fd==null)
			fd="ename";
		else if(fd.equals("hiredate"))
			fd="TO_CHAR(hiredate, 'YYYY')";
		if(ss==null)
			ss="";
		Map map=new HashedMap();
		map.put("fd", fd.toUpperCase());
		map.put("ss", ss.toUpperCase());
		List<EmpVO> list=dao.empFindOption(map);
		model.addAttribute("list", list);
		return "emp/findSec";
	}
}
