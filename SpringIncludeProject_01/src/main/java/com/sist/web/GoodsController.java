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

import com.sist.service.GoodsService;
import com.sist.vo.GoodsVO;

@Controller
@RequestMapping("goods/")
public class GoodsController {
	@Autowired
	GoodsService gService;
	
	@GetMapping("list.do")
	public String goodsList(String page, Model model, HttpServletRequest request) {
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int rowSize=20;
		int start=(curPage-1)*rowSize+1;
		int end=start+rowSize-1;
		int totalPage=gService.goodsTotalPage();
		int startPage=(curPage)/10*10+1;
		int endPage=startPage+10-1;
		if(endPage>totalPage)
			endPage=totalPage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<GoodsVO> list=gService.goodsListData(map);
		
		List<GoodsVO> gList=new ArrayList<GoodsVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("goods_")) {
					GoodsVO vo=gService.goodsDetailData(Integer.parseInt(cookies[i].getValue()));
					gList.add(vo);
				}
			}
		}
		model.addAttribute("gList", gList);
		model.addAttribute("size", gList.size());
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../goods/list.jsp");
		return "main/main";
	}
	@GetMapping("detailBefore.do")
	public String goodDetailBefore(int no, HttpServletResponse response, RedirectAttributes ra) {
		Cookie cookie=new Cookie("goods_"+no, String.valueOf(no));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("no", no);
		return "redirect:../goods/detail.do";
	}
	@GetMapping("detail.do")
	public String goodsDetail(int no, Model model) {
		GoodsVO vo=gService.goodsDetail(no);
		model.addAttribute("detail", vo);
		model.addAttribute("main_jsp", "../goods/detail.jsp");
		return "main/main";
	}
	@GetMapping("goodsCookieAll.do")
	public String goodsCookieAll(HttpServletRequest request, Model model) {
		Cookie[] cookies=request.getCookies();
		List<GoodsVO> gList=new ArrayList<GoodsVO>();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("goods_")) {
					GoodsVO vo=gService.goodsDetailData(Integer.parseInt(cookies[i].getValue()));
					gList.add(vo);
				}
			}
		}
		model.addAttribute("gList", gList);
		model.addAttribute("size", gList.size());
		model.addAttribute("main_jsp", "../goods/cookieAll.jsp");
		return "main/main";
	}
	@GetMapping("goodsCookieDelete.do")
	public String goodsCookieAllDelete(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("goods_")) {
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		return "redirect:../goods/list.do";
	}
}
