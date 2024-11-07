package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.*;
import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;

	@GetMapping(value = "board/vueList.do", produces = "text/plain;charset=UTF-8")
	public String boardVueList(int page) throws Exception {
		Map map = new HashMap();
		int start = (page - 1) * 10 + 1;
		int end = start + 10 - 1;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list = dao.boardListData(map);
		int count = dao.boardTotalPage();
		int totalPage = (int) (Math.ceil(count / 10.0));
		count = count - (page - 1) * 10;
		map.put("list", list);
		map.put("totalPage", totalPage);
		map.put("curPage", page);
		map.put("count", count);
		JsonMapper mapper = new JsonMapper();
		String json = mapper.writeValueAsString(map);
		return json;
	}

	@PostMapping(value = "board/vueInsert.do", produces = "text/plain;charset=UTF-8")
	public String boardVueInsert(BoardVO vo, HttpServletRequest request) {
		String result = "";
		try {
			String path = request.getSession().getServletContext().getRealPath("/") + "upload\\";
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdir();
			}
			path = path.replace("\\", File.separator);
			List<MultipartFile> list = vo.getFiles();
			if (list == null) {
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
			} else {
				String filename = "";
				String filesize = "";
				for (MultipartFile mf : list) {
					String name = mf.getOriginalFilename();
					File file = new File(path + name);
					mf.transferTo(file);
					filename += name + ",";
					filesize += file.length() + ",";
				}
				filename = filename.substring(0, filename.lastIndexOf(","));
				filesize = filesize.substring(0, filesize.lastIndexOf(","));
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(vo.getFiles().size());
			}
			dao.boardInsert(vo);
			result = "OK";
		} catch (Exception e) {
			result = "NO";
		}
		return result;
	}

	@GetMapping(value = "board/vueDetail.do", produces = "text/plain;charset=UTF-8")
	public String boardVueDetail(int no) throws Exception {
		BoardVO vo = dao.boardDetail(no);
		JsonMapper mapper = new JsonMapper();
		String json = mapper.writeValueAsString(vo);
		return json;
	}

	@GetMapping(value = "board/download.do", produces = "text/plain;charset=UTF-8")
	public void boardDownload(String fn, HttpServletResponse response, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/") + "upload\\";
			path = path.replace("\\", File.separator);
			File file = new File(path + fn);
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fn, "UTF-8"));
			response.setContentLength((int) file.length());
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			int i = 0;
			byte[] buffer = new byte[1024];
			while ((i = bis.read(buffer, 0, 1024)) != -1) {
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
		} catch (Exception e) {
		}
	}

	@GetMapping(value = "board/vueDelete.do", produces = "text/plain;charset=UTF-8")
	public String boardVueDelete(int no, String pwd, HttpServletRequest request) {
		String filename = dao.boardFileInfoData(no);
		String result = dao.boardDelete(no, pwd);
		if (result == "OK") {
			String path = request.getSession().getServletContext().getRealPath("/") + "upload\\";
			path = path.replace("\\", File.separator);
			if (filename != null) {
				StringTokenizer st = new StringTokenizer(filename, ",");
				while (st.hasMoreTokens()) {
					File file = new File(path + st.nextToken());
					file.delete();
				}
			}

		}
		return result;
	}

	@GetMapping(value = "board/vueDetailData.do", produces = "text/plain;charset=UTF-8")
	public String boardVueDetailData(int no) throws Exception {
		BoardVO vo = dao.boardDetailData(no);
		JsonMapper mapper = new JsonMapper();
		String json = mapper.writeValueAsString(vo);
		return json;
	}

	@PostMapping(value = "board/vueUpdate.do", produces = "text/plain;charset=UTF-8")
	public String boardVueUpdate(BoardVO vo, HttpServletRequest request) throws Exception {
		System.out.println(vo.getNo());
		try {
			String filename = dao.boardFileInfoData(vo.getNo());
			String path = request.getSession().getServletContext().getRealPath("/") + "upload\\";
			path = path.replace("\\", File.separator);
			if (filename != null) {
				StringTokenizer st = new StringTokenizer(filename, ",");
				while (st.hasMoreTokens()) {
					File file = new File(path + st.nextToken());
					file.delete();
				}
			}
			List<MultipartFile> list = vo.getFiles();
			if (list == null) {
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
			} else {
				String filenames = "";
				String filesize = "";
				for (MultipartFile mf : list) {
					String name = mf.getOriginalFilename();
					File file = new File(path + name);
					mf.transferTo(file);
					filenames += name + ",";
					filesize += file.length() + ",";
				}
				filenames = filenames.substring(0, filenames.lastIndexOf(","));
				filesize = filesize.substring(0, filesize.lastIndexOf(","));
				vo.setFilename(filenames);
				vo.setFilesize(filesize);
				vo.setFilecount(vo.getFiles().size());
			}
		} catch (Exception e) {
		}
		String result = dao.boardUpdate(vo);

		return result;
	}
}
