package com.sist.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.RecipeService;
import com.sist.vo.*;

@Controller
@RequestMapping("recipe/")
public class RecipeController {
	@Autowired
	private RecipeService rService;

	@GetMapping("detailBefore.do")
	public String recipeDetailBefore(int no, HttpServletResponse response, RedirectAttributes ra) {
		Cookie cookie = new Cookie("recipe_" + no, String.valueOf(no));
		cookie.setMaxAge(24 * 60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
		ra.addAttribute("no", no);
		return "redirect:../recipe/detail.do";
	}

	@GetMapping("detail.do")
	public String recipeDetail(int no, Model model) {
		RecipeDetailVO vo = rService.recipeDetailData(no);
		List<String> mList = new ArrayList<String>();
		List<String> iList = new ArrayList<String>();
		String[] make = vo.getFoodmake().split("\n");
		for (String s : make) {
			StringTokenizer st = new StringTokenizer(s, "^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		String data = vo.getData();
		data = data.replace("±¸¸Å", "");
		vo.setData(data.trim());
		model.addAttribute("mList", mList);
		model.addAttribute("iList", iList);
		model.addAttribute("detail", vo);
		model.addAttribute("main_jsp", "../recipe/detail.jsp");
		return "main/main";
	}

	@GetMapping("chefList.do")
	public String chefList(String page, Model model) {
		if (page == null)
			page = "1";
		int curPage = Integer.parseInt(page);
		Map map = new HashedMap();
		int start = (curPage - 1) * 50 + 1;
		int end = start + 50 - 1;
		map.put("start", start);
		map.put("end", end);
		int count = rService.chefRowCount();
		int totalPage = (int) (Math.ceil(count / 20.0));
		List<ChefVO> list = rService.chefListData(map);
		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		model.addAttribute("count", count);
		model.addAttribute("curPage", curPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../recipe/chefList.jsp");
		return "main/main";
	}

	@GetMapping("chefDetail.do")
	public String chefDetail(String page, String chef, Model model) {
		if (page == null)
			page = "1";
		int curPage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curPage - 1) * rowSize + 1;
		int end = start + rowSize - 1;
		Map map = new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("chef", chef);
		List<RecipeVO> list = rService.chefRecipeListData(map);
		int count = rService.chefRecipeRowCount(map);
		int totalPage = (int) (Math.ceil(count / 12.0));
		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		if (endPage > totalPage)
			endPage = totalPage;
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("chef", chef);
		model.addAttribute("main_jsp", "../recipe/chefDetail.jsp");
		return "main/main";
	}

	@GetMapping("cookieAll.do")
	public String cookieAll(HttpServletRequest request, Model model) {
		Cookie[] cookies = request.getCookies();
		List<RecipeVO> rList = new ArrayList<RecipeVO>();
		if (cookies != null) {
			for (int i = cookies.length - 1; i >= 0; i--) {
				if (cookies[i].getName().startsWith("recipe_")) {
					int no = Integer.parseInt(cookies[i].getValue());
					RecipeVO vo = rService.recipeCookieData(no);
					rList.add(vo);
				}
			}
		}
		model.addAttribute("rList", rList);
		model.addAttribute("size", rList.size());
		model.addAttribute("main_jsp", "../recipe/cookieAll.jsp");
		return "main/main";
	}
	@GetMapping("cookieDelete.do")
	public String cookieDelete(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().startsWith("recipe_")) {
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		return "redirect:../main/main.do";
	}
	@RequestMapping("find.do")
	public String recipeFind(String fd, String page, Model model) {
		if(page==null)
			page="1";
		if(fd==null)
			fd="";
		int curPage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=20;
		int start=(curPage-1)*rowSize+1;
		int end=start+rowSize-1;
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		List<RecipeVO> list=rService.recipeFindListData(map);
		int count=rService.recipeFindRowCount(map);
		int totalPage=(int)(Math.ceil(count/20.0));
		int startPage=(curPage-1)/10*10+1;
		int endPage=startPage+10-1;
		if(endPage>totalPage)
			endPage=totalPage;
		model.addAttribute("count", count);
		model.addAttribute("curPage", curPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		model.addAttribute("fd", fd);
		model.addAttribute("main_jsp", "../recipe/find.jsp");
		return "main/main";
	}
}