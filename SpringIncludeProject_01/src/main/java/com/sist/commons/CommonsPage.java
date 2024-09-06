package com.sist.commons;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.sist.vo.RecipeVO;

public class CommonsPage {
	public static Map pageConfig(String page, int rowSize) {
		if (page == null)
			page = "1";
		int curPage = Integer.parseInt(page);
		Map map = new HashedMap();
		int start = (curPage - 1) * rowSize + 1;
		int end = start + rowSize - 1;
		map.put("start", start);
		map.put("end", end);
		map.put("curPage", curPage);
		return map;
	}
}
