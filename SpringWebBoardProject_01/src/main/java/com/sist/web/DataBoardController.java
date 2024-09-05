package com.sist.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
@RequestMapping("databoard/")
public class DataBoardController {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private DataBoardDAO dao;

	@GetMapping("list.do")
	public String databoardList(String page, Model model) {
		String en = encoder.encode("1234");
		System.out.println(en);
		if (page == null)
			page = "1";
		int curPage = Integer.parseInt(page);
		int start = (curPage - 1) * 10 + 1;
		int end = start + 10 - 1;
		List<DataBoardVO> list = dao.databoardListData(start, end);
		int count = dao.databoardCount();
		int startPage = (curPage) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		int totalPage = (int) (Math.ceil(count / 10.0));
		if (endPage > totalPage)
			endPage = totalPage;
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("count", count);
		return "databoard/list";
	}

	@GetMapping("insert.do")
	public String databoardInsert() {
		return "databoard/insert";
	}

	@PostMapping("insertOk.do")
	public String databoardInsertOk(DataBoardVO vo) {
		String en = encoder.encode(vo.getPwd());
		vo.setPwd(en);
		String path = "c:\\springUpload";
		List<MultipartFile> list = vo.getFiles();
		if (list == null) {
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		} else {
			try {
				String filename = "";
				String filesize = "";
				for (MultipartFile mf : list) {
					String name = mf.getOriginalFilename();
					File file = new File(path + "\\" + name);
					mf.transferTo(file);
					filename += file.getName() + ",";
					filesize += file.length() + ",";
				}
				filename = filename.substring(0, filename.lastIndexOf(","));
				filesize = filesize.substring(0, filesize.lastIndexOf(","));
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
				dao.databoardInsert(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:list.do";
	}

	@GetMapping("detail.do")
	public String databoardDetail(int no, Model model) {
		DataBoardVO vo = dao.databoardDetail(no);
		if (vo.getFilecount() != 0) {
			List<String> nList = new ArrayList<String>();
			List<String> cList = new ArrayList<String>();
			String[] names = vo.getFilename().split(",");
			String[] length = vo.getFilesize().split(",");
			nList = Arrays.asList(names);
			cList = Arrays.asList(length);
			model.addAttribute("nList", nList);
			model.addAttribute("cList", cList);
		}
		model.addAttribute("detail", vo);
		return "databoard/detail";
	}

	@GetMapping("download.do")
	public void databoardDownload(String fn, HttpServletResponse response) {
		try {
			String path = "c:\\springUpload";
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "\\" + fn));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(fn, "UTF-8"));
			File file = new File(path + "\\" + fn);
			response.setContentLength((int) file.length());
			byte[] buffer = new byte[1024];
			int i = 0;
			while ((i = bis.read(buffer, 0, 1024)) != -1) {
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("update.do")
	public String databoardUpdate(int no, Model model) {
		return "databoard/update";
	}
	@GetMapping("delete.do")
	public String databoardDelete(int no, Model model) {
		model.addAttribute("no", no);
		return "databoard/delete";
	}
}
