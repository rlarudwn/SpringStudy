package com.sist.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

@Controller
@RequestMapping("food/")
public class FoodController {
	@Autowired
	private FoodService fService;
	@GetMapping("list.do")
	public String foodList(String page, Model model, HttpServletRequest request) {
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int rowSize=20;
		int start=(curPage-1)*rowSize+1;
		int end=start+rowSize-1;
		int totalPage=fService.foodTotalPage();
		int startPage=(curPage)/10*10+1;
		int endPage=startPage+10-1;
		if(endPage>totalPage)
			endPage=totalPage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=fService.foodListData(map);
		
		List<FoodVO> fList=new ArrayList<FoodVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("food_")) {
					FoodVO vo=fService.foodDetailData(Integer.parseInt(cookies[i].getValue()));
					fList.add(vo);
				}
			}
		}
		model.addAttribute("fList", fList);
		model.addAttribute("size", fList.size());
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../food/list.jsp");
		return "main/main";
	}
	@GetMapping("detailBefore.do")
	public String foodDetailBefore(int fno, HttpServletResponse response, RedirectAttributes ra) {
		Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("fno", fno);
		return "redirect:../food/detail.do";
	}
	@GetMapping("detail.do")
	public String foodDetail(int fno, Model model) {
		FoodVO vo=fService.foodDetail(fno);
		model.addAttribute("detail", vo);
		model.addAttribute("main_jsp", "../food/detail.jsp");
		return "main/main";
	}
	@GetMapping("foodCookieAll.do")
	public String foodCookieAll(HttpServletRequest request, Model model) {
		List<FoodVO> fList=new ArrayList<FoodVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("food_")) {
					FoodVO vo=fService.foodDetailData(Integer.parseInt(cookies[i].getValue()));
					fList.add(vo);
				}
			}
		}
		model.addAttribute("fList", fList);
		model.addAttribute("size", fList.size());
		model.addAttribute("main_jsp", "../food/cookieAll.jsp");
		return "main/main";
	}
	@GetMapping("foodCookieDelete.do")
	public String foodCookieAllDelete(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("food_")) {
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		return "redirect:../food/list.do";
	}
}
