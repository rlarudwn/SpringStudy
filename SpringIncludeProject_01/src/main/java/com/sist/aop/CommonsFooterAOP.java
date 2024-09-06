package com.sist.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.service.*;
import com.sist.vo.*;

@Aspect
@Component
public class CommonsFooterAOP {
	@Autowired
	private RecipeService rService;
	@Autowired
	private FoodService fService;

	@After("execution(* com.sist.web.*Controller.*(..))")
	public void commonsFoodterData() {
		List<FoodVO> ftList = fService.foodTop5ListData();
		List<RecipeVO> rtList = rService.recipeTop5ListData();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("ftList", ftList);
		request.setAttribute("rtList", rtList);
	}

	@After("execution(* com.sist.web.RecipeController.*(..))")
	public void recipeCookie() {
		List<RecipeVO> rcList = new ArrayList<RecipeVO>();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = cookies.length - 1; i >= 0; i--) {
				if (cookies[i].getName().startsWith("recipe_")) {
					int no = Integer.parseInt(cookies[i].getValue());
					RecipeVO vo = rService.recipeCookieData(no);
					rcList.add(vo);
				}
			}
		}
		request.setAttribute("rcList", rcList);
		request.setAttribute("size", rcList.size());
	}
}
